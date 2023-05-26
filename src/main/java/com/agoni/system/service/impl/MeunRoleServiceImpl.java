package com.agoni.system.service.impl;

import com.agoni.system.mapper.MeunRoleMapper;
import com.agoni.system.model.po.MeunRole;
import com.agoni.system.service.MeunRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author gyd
* @description 针对表【sys_meun_role(菜单角色关联表)】的数据库操作Service实现
* @createDate 2022-08-10 00:08:03
*/
@Service
public class MeunRoleServiceImpl extends ServiceImpl<MeunRoleMapper, MeunRole>
    implements MeunRoleService{
    
    /**
     * 根据角色 id 查询菜单ids
     * @param mr
     *
     * @return
     */
    @Override
    public List<MeunRole> getlist(MeunRole mr) {
        QueryWrapper<MeunRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ObjectUtils.isNotEmpty(mr.getRoleId()),MeunRole::getRoleId,mr.getRoleId());
        return list(queryWrapper);
    }
}




