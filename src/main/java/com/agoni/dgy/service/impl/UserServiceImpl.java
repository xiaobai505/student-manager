package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.RoleMapper;
import com.agoni.dgy.model.from.UserAndRoleFrom;
import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.mapper.UserMapper;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.service.RoleService;
import com.agoni.dgy.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public IPage<UserAndRole> selectpage(Page<UserAndRole> page, UserAndRole userAndRole) {
        return userMapper.selectUserAndRolepage(page,userAndRole);
    }

    @Override
    public void saveUserAndRole(UserAndRoleFrom userAndRole) {
        User user = userAndRole.getUser();
        userMapper.insert(user);
        Role role = userAndRole.getRole();
        if (role == null){return;}
        roleMapper.insert(role);
        log.info(user.getId()+"---"+role.getId());

        return;
    }

    private LambdaQueryWrapper<User> getUserLambdaQueryWrapper(User user) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(User::getName,user.getName());
        return queryWrapper;
    }

}
