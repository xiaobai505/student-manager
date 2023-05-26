package com.agoni.system.service;

import com.agoni.dgy.model.query.PwdQuery;
import com.agoni.system.model.po.User;
import com.agoni.system.model.query.UserQuery;
import com.agoni.system.model.vo.UserAndRole;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户服务
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author dgy
 * @date 2023/03/21
 * @since 2021-12-22
 */
public interface UserService extends IService<User> {
    
    /**
     * 页面用户
     * 多表关联查询用户信息
     *
     * @param userQuery 用户查询
     *
     * @return IPage<UserAndRole>
     */
    IPage<UserAndRole> pageUser(UserQuery userQuery);
    
    /**
     * 获取用户用户名
     *
     * @param username 用户名
     *
     * @return {@link User}
     */
    User getUserByUserName(String username);
    
    /**
     * 修改新密码
     * @param pq
     *
     * @return
     */
    boolean resetPwd(PwdQuery pq);


}
