package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.RoleUserMapper;
import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.model.vo.RoleUserVo;
import com.agoni.dgy.service.MajorService;
import com.agoni.dgy.service.RoleService;
import com.agoni.dgy.service.RoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MajorService majorService;


    @Override
    public List<RoleUserVo> selectRolebyUserId(Long id) {
        List<RoleUserVo> roleUserVos = roleUserMapper.selectUserAndRole(id);
        return roleUserVos;
    }

    @Override
    public List<String> getSchoolList() {
        List<Major> mjlist = majorService.list();
        List<String> schoolList = mjlist.stream().map(Major::getSchool).distinct().collect(Collectors.toList());
        return schoolList;
    }

}
