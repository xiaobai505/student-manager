package com.agoni.dgy.service;

import com.agoni.dgy.model.from.UserAndRoleFrom;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.UserAndRole;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
public interface UserService extends IService<User> {

    /**
     * 多表关联查询用户信息
     * @param page
     * @param userAndRole
     * @return
     */
    IPage<UserAndRole> selectpage(Page<UserAndRole> page, UserAndRole userAndRole);

    void saveUserAndRole(UserAndRoleFrom userAndRole);
}
