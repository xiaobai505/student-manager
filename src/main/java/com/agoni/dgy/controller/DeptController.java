package com.agoni.dgy.controller;

import com.agoni.dgy.model.po.Dept;
import com.agoni.dgy.model.query.DeptQuery;
import com.agoni.dgy.model.vo.DeptVo;
import com.agoni.dgy.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return new ResponseEntity<>(deptVos, HttpStatus.OK);
    }
    
    @PostMapping
    @ApiOperation("保存部门")
    public ResponseEntity<Boolean> save(@RequestBody Dept dept) {
        boolean save = deptService.saveDept(dept);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }
    
    @PutMapping
    @ApiOperation("更新部门")
    public ResponseEntity<Boolean> update(@RequestBody Dept dept) {
        boolean save = deptService.updateById(dept);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResponseEntity<Boolean> del(@PathVariable long id) {
        boolean res = deptService.removeById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    
    
}
