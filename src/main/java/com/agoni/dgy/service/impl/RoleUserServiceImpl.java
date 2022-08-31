package com.agoni.dgy.service.impl;

import com.agoni.core.Binder;
import com.agoni.dgy.mapper.RoleUserMapper;
import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.model.vo.RoleUserVo;
import com.agoni.dgy.service.MajorService;
import com.agoni.dgy.service.RoleService;
import com.agoni.dgy.service.RoleUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
@Slf4j
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Autowired
    private MajorService majorService;
    
    @Autowired
    private RoleService roleService;


    @Override
    public List<RoleUserVo> getRolebyUserId(Long id) {
        List<RoleUserVo> roleUserVos = roleUserMapper.selectUserAndRole(id);
        return Binder.convertAndBindRelations(roleUserVos,RoleUserVo.class);
    }

    @Override
    public List<String> getSchoolList() {
        List<Major> mjlist = majorService.list();
        return mjlist.stream().map(Major::getSchool).distinct().collect(Collectors.toList());
    }
    
    @Override
    public boolean saveByUserId(Long userId, List<Long> ids) {
        // 删除原来的权限
        boolean b1 = this.removeByUserid(userId);
        List<Role> roles = roleService.listByIds(ids);
        // 新增权限
        List<RoleUser> infos= new ArrayList<>();
        roles.forEach(role -> infos.add(RoleUser.builder().roleId(role.getId()).userId(userId).roleName(role.getRoleName()).build()));
        boolean b2 = this.saveOrUpdateBatch(infos);
        return b1 && b2;
    }
    
    @Override
    public boolean removeByUserid(Long userId) {
        if (ObjectUtils.isNull(userId)) {
            return false;
        }
        QueryWrapper<RoleUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(RoleUser::getUserId,userId);
        return this.remove(wrapper);
    }
}
