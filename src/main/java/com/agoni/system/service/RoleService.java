package com.agoni.system.service;

import com.agoni.system.model.po.Role;
import com.agoni.system.model.query.RolePageQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
public interface RoleService extends IService<Role> {

    /**
     * 分页查询
     * @param from
     * @return
     */
    IPage<Role> selectPage(RolePageQuery from);

    
    /**
     * 根据 code 查询 Role
     * @return
     */
    Role getByCode(String code);
}
