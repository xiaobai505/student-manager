package com.agoni.system.controller;


import com.agoni.system.model.po.Role;
import com.agoni.system.model.query.RoleQuery;
import com.agoni.system.model.response.ResponseEntity;
import com.agoni.system.service.RoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/sys/role")
@Api(tags="角色")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/page")
    @ApiOperation("分页列表")
    public ResponseEntity<IPage<Role>> page(@Validated RoleQuery from) {
        from.setOrderBy("role_sort");
        from.setOrder(Constants.ASC);
        IPage<Role> page = roleService.selectPage(from);
        return ResponseEntity.body(page);
    }

    @GetMapping
    @ApiOperation("分页列表")
    public ResponseEntity<List<Role>> List() {
        List<Role> list = roleService.list();
        return ResponseEntity.body(list);
    }
    
    @PostMapping
    @ApiOperation("保存角色")
    public ResponseEntity<Boolean> saveOrUpdate(@RequestBody Role role) {
        boolean res = roleService.saveOrUpdate(role);
        return ResponseEntity.body(res);
    }
    
    @PutMapping
    @ApiOperation("更新角色")
    public ResponseEntity<Boolean> update(@RequestBody Role role) {
        boolean res = roleService.updateById(role);
        return ResponseEntity.body(res);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResponseEntity<Boolean> del(@PathVariable long id) {
        boolean res = roleService.removeById(id);
        return ResponseEntity.body(res);
    }

}
