package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.RoleMapper;
import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.service.RoleService;
import com.agoni.dgy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleMapper roleMapper;

}
