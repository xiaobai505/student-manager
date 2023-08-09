package com.agoni.system.service.impl;

import com.agoni.core.omp.OmpServiceImpl;
import com.agoni.system.mapper.RoleMapper;
import com.agoni.system.model.po.Role;
import com.agoni.system.model.query.RoleQuery;
import com.agoni.system.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
public class RoleServiceImpl extends OmpServiceImpl<RoleMapper, Role> implements RoleService {


    @Override
    public IPage<Role> selectPage(RoleQuery from) {
        return this.getPage(from);
    }

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
