package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.service.RoleUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<Long>> getByid(@PathVariable Long id) {
        QueryWrapper<RoleUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(RoleUser::getUserId,id);
        List<RoleUser> list = roleUserService.list(wrapper);
        List<Long> ids = list.stream().map(RoleUser::getRoleId).collect(Collectors.toList());
        return new ResponseEntity<List<Long>>(ids, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<RoleUser>> list() {
        List<RoleUser> list = roleUserService.list();
        return new ResponseEntity<List<RoleUser>>(list, HttpStatus.OK);
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<Boolean> save(@PathVariable Long id) {
        boolean save = roleUserService.save(null);
        return new ResponseEntity<Boolean>(save, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id) {
        boolean save = roleUserService.update(null);
        return new ResponseEntity<Boolean>(save, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        boolean res = roleUserService.removeByIds(null);
        return new ResponseEntity<Boolean>(res, HttpStatus.OK);
    }
    
}
