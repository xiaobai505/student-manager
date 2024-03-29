package com.agoni.system.service.impl;

import com.agoni.core.diboot.Binder;
import com.agoni.system.mapper.RoleUserMapper;
import com.agoni.system.model.po.Role;
import com.agoni.system.model.po.RoleUser;
import com.agoni.system.model.vo.RoleUserVo;
import com.agoni.system.service.RoleService;
import com.agoni.system.service.RoleUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
@Slf4j
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

    @Autowired
    private RoleService roleService;


    @Override
    public List<RoleUserVo> getRolebyUserId(Long id) {
        QueryWrapper<RoleUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RoleUser::getUserId, id);
        List<RoleUser> list = this.list(queryWrapper);
        return Binder.convertAndBindRelations(list, RoleUserVo.class);
    }

    @Override
    public boolean saveByUserId(Long userId, List<Long> ids) {
        // 删除原来的权限
        boolean b1 = this.removeByUserid(userId);
        List<Role> roles = roleService.listByIds(ids);
        // 新增权限
        List<RoleUser> infos= new ArrayList<>();
        roles.forEach(role -> infos.add(RoleUser.builder().roleId(role.getId()).userId(userId).build()));
        boolean b2 = this.saveOrUpdateBatch(infos);
        return b1 && b2;
    }
    
    @Override
    public boolean removeByUserid(Long userId) {
        if (ObjectUtils.isNull(userId)) {
            return false;
        }
        QueryWrapper<RoleUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(RoleUser::getUserId,userId);
        return this.remove(wrapper);
    }
}
