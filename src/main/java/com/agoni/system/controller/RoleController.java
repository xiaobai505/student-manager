package com.agoni.system.controller;


import com.agoni.system.model.bo.RoleSearchFrom;
import com.agoni.system.model.po.Role;
import com.agoni.system.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation("分页列表")
    public ResponseEntity<Page> page(@Validated RoleSearchFrom from) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByAsc(Role::getRoleSort);
        Page res = roleService.page(from, queryWrapper);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PostMapping
    @ApiOperation("保存角色")
    public ResponseEntity<Boolean> save(@RequestBody Role role) {
        boolean b = roleService.save(role);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @PutMapping
    @ApiOperation("更新角色")
    public ResponseEntity<Boolean> update(@RequestBody Role role) {
        boolean b = roleService.updateById(role);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResponseEntity<Boolean> del(@PathVariable long id) {
        boolean res = roleService.removeById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
