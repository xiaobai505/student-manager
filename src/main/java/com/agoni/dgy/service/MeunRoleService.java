package com.agoni.dgy.service;

import com.agoni.dgy.model.po.MeunRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author gyd
* @description 针对表【tb_meun_role(菜单角色关联表)】的数据库操作Service
* @createDate 2022-08-10 00:08:03
*/
public interface MeunRoleService extends IService<MeunRole> {
    
    /**
     * 根据角色 id 查询菜单ids
     * @param mr
     *
     * @return
     */
    List<MeunRole> getlist(MeunRole mr);
}
