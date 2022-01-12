package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.RoleUserMapper;
import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.model.vo.RoleUserVo;
import com.agoni.dgy.service.RoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<RoleUserVo> selectRolebyUserId(Long id) {
        List<RoleUserVo> roleUserVos = roleUserMapper.selectUserAndRole(id);
        return roleUserVos;
    }
}
