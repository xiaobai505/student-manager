package com.agoni.dgy.service;

import com.agoni.dgy.model.bo.AddUserFrom;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.query.PwdQuery;
import com.agoni.dgy.model.query.UserQuery;
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
     * @param userQuery
     * @return IPage<UserAndRole>
     */
    IPage<UserAndRole> pageUser(UserQuery userQuery);

    /**
     * 新增用户 user role major 信息
     * @param userAndRole
     */
    void saveUserAndRole(AddUserFrom userAndRole);
    
    /**
     * 修改新密码
     * @param pq
     *
     * @return
     */
    boolean resetPwd(PwdQuery pq);


}
