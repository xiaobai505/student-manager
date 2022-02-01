package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.service.RoleUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/dgy/role-user")
public class RoleUserController {
    @Autowired
    private RoleUserService roleUserService;


    @GetMapping("/list/{id}")
    public List<RoleUser> get(@PathVariable Long id) {
        QueryWrapper<Role> Wrapper = new QueryWrapper<>();
        List<RoleUser> list = roleUserService.list();
        return list;
    }

}
