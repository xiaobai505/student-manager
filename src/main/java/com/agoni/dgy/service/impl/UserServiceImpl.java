package com.agoni.dgy.service.impl;

import com.agoni.dgy.model.User;
import com.agoni.dgy.mapper.UserMapper;
import com.agoni.dgy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
