package com.agoni.system.service.impl;

import com.agoni.core.diboot.Binder;
import com.agoni.dgy.model.query.PwdQuery;
import com.agoni.system.mapper.UserMapper;
import com.agoni.system.model.po.User;
import com.agoni.system.model.query.UserQuery;
import com.agoni.system.model.vo.UserVo;
import com.agoni.system.service.UserService;
import com.agoni.system.utils.UserUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @Override
    public IPage<UserVo> pageUser(UserQuery userQuery) {
        IPage<UserVo> iPage = userMapper.selectUserAndRolepage(userQuery, userQuery);
        return Binder.bindRelations(iPage);
    }

    /**
     * 获取用户用户名
     *
     * @param username 用户名
     *
     * @return {@link User}
     */
    @Override
    public User getUserByUserName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername,username);
        return getOne(queryWrapper);
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
