package com.agoni.dgy.service.impl;

import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.mapper.RoleUserMapper;
import com.agoni.dgy.service.RoleUserService;
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
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

}
