package com.agoni.dgy.controller;


import com.agoni.dgy.model.bo.RoleSearchFrom;
import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/dgy/role")
@Api(tags="角色")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/page")
    @ApiOperation("分页获取角色信息")
    public ResponseEntity<Page> page(@Validated RoleSearchFrom roleSearchFrom) {
        Page res = roleService.page(roleSearchFrom, new QueryWrapper<>());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("获取角色信息")
    public ResponseEntity<List> list(){
        List<Role> list = roleService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
