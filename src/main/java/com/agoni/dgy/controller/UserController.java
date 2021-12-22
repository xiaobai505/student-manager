package com.agoni.dgy.controller;


import com.agoni.dgy.model.User;
import com.agoni.dgy.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 dgy前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/dgy/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list() {
        List<User> list = userService.list();
        return list;
    }

    @RequestMapping("/page")
    public IPage<User> page() {
        return userService.page(new Page(1,5),null);
    }
}
