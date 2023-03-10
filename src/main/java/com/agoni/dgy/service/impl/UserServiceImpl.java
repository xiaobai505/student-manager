package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.MajorMapper;
import com.agoni.dgy.mapper.RoleMapper;
import com.agoni.dgy.mapper.UserMapper;
import com.agoni.dgy.model.bo.AddUserFrom;
import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.query.PwdQuery;
import com.agoni.dgy.model.query.UserQuery;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.service.UserService;
import com.agoni.system.utils.UserUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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
    @Autowired
    private MajorMapper majorMapper;

    @Override
    public IPage<UserAndRole> pageUser(UserQuery userQuery) {
        return userMapper.selectUserAndRolepage(userQuery, userQuery);
    }

    @Override
    public void saveUserAndRole(AddUserFrom userAndRole) {
        // 1：插入用户
        User user = userAndRole.getUser();
        userMapper.insert(user);
        // 2：插入权限
        Role role = userAndRole.getRole();
        if (role == null){return;}
        roleMapper.insert(role);
        log.info(user.getId()+"---"+role.getId());
        // 3：插入班级
        Major major = userAndRole.getMajor();
        if (major==null){return;}
        majorMapper.insert(major);
    }
    
    /**
     * @return
     */
    @Override
    public boolean resetPwd(PwdQuery pq) {
        // 当前用户密码
        User user = UserUtil.getUser();
        if (StringUtils.equals(pq.getOldPassword(), user.getPassword())) {
            User u = User.builder().id(user.getId()).password(pq.getConfirmPassword()).build();
            return updateById(u);
        }
        return false;
    }
    
    private LambdaQueryWrapper<User> getUserLambdaQueryWrapper(User user) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(User::getName,user.getName());
        return queryWrapper;
    }

}
