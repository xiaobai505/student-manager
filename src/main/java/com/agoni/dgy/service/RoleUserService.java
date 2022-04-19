package com.agoni.dgy.service;

import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.model.vo.RoleUserVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 服务类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
public interface RoleUserService extends IService<RoleUser> {

    /**
     * 根据 user_id 查询用户权限
     * @param id
     * @return list
     */
    List<RoleUserVo> getRolebyUserId(Long id);

    List<String> getSchoolList();
    
    /**
     * 根据 user_id 提交用户权限
     * @param userId 用户id
     * @param ids 提交的权限id
     * @return boolean
     */
    boolean saveByUserId(Long userId, List<Long> ids);
    

}
