package com.agoni.dgy.service;

import com.agoni.dgy.model.bo.AddUserFrom;
import com.agoni.dgy.model.bo.UserSearchFrom;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.UserAndRole;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
     * @param userSearchFrom
     * @return IPage<UserAndRole>
     */
    IPage<UserAndRole> pageUser(UserSearchFrom userSearchFrom);

    /**
     * 新增用户 user role major 信息
     * @param userAndRole
     */
    void saveUserAndRole(AddUserFrom userAndRole);


}
