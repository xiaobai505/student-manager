package com.agoni.system.controller;

import com.agoni.dgy.model.query.DeptQuery;
import com.agoni.dgy.model.vo.DeptVo;
import com.agoni.system.model.po.Dept;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gyd
 */
@RestController
@RequestMapping("/dgy/dept")
@Api(tags = "部门")
public class DeptController {
    
    @Autowired
    private DeptService deptService;
    
    @GetMapping
    @ApiOperation("列表")
    public ResponseEntity<List> listByQuery(@Validated DeptQuery dq) {
        List<DeptVo> deptVos = deptService.listByQuery(dq);
        return ResponseEntity.body(deptVos);
    }
    
    @PostMapping
    @ApiOperation("保存部门")
    public ResponseEntity<Boolean> save(@RequestBody Dept dept) {
        boolean save = deptService.saveDept(dept);
        return ResponseEntity.body(save);
    }
    
    @PutMapping
    @ApiOperation("更新部门")
    public ResponseEntity<Boolean> update(@RequestBody Dept dept) {
        boolean save = deptService.updateById(dept);
        return ResponseEntity.body(save);
    }
    
    
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResponseEntity<Boolean> del(@PathVariable long id) {
        boolean res = deptService.removeById(id);
        return ResponseEntity.body(res);
    }
    
    
    
}
