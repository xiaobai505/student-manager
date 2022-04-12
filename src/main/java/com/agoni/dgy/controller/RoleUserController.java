package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.service.RoleUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/dgy/roleUser")
public class RoleUserController {
    @Autowired
    private RoleUserService roleUserService;
    
    @GetMapping("/{id}")
    public ResponseEntity<List<RoleUser>>getByid(@PathVariable Long id) {
        QueryWrapper<RoleUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(RoleUser::getUserId,id);
        List<RoleUser> list = roleUserService.list(wrapper);
        return new ResponseEntity<List<RoleUser>>(list, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<RoleUser>> list() {
        List<RoleUser> list = roleUserService.list();
        return new ResponseEntity<List<RoleUser>>(list, HttpStatus.OK);
    }
}
