package com.agoni.system.service.impl;

import com.agoni.system.mapper.RoleMapper;
import com.agoni.system.model.po.Role;
import com.agoni.system.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    
    /**
     * 根据 code 查询 Role
     * @return
     */
    @Override
    public Role getByCode(String code) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Role::getRoleCode,code);
        return getOne(queryWrapper);
    }
}
