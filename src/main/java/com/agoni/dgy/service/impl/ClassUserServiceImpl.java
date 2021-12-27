package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.ClassUserMapper;
import com.agoni.dgy.model.po.ClassUser;
import com.agoni.dgy.service.ClassUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
public class ClassUserServiceImpl extends ServiceImpl<ClassUserMapper, ClassUser> implements ClassUserService {

}
