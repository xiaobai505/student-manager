package com.agoni.dgy.controller;

import com.agoni.core.Binder;
import com.agoni.dgy.model.bo.DeptSearchFrom;
import com.agoni.dgy.model.po.Dept;
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
    public ResponseEntity<List> list(@Validated DeptSearchFrom deptSearchFrom) {
        List<Dept> list = deptService.list();
        List<DeptVo> vos = Binder.convertAndBindRelations(list, DeptVo.class);
        return new ResponseEntity<>(vos, HttpStatus.OK);
    }
    
    @PostMapping
    @ApiOperation("保存部门")
    public ResponseEntity<Boolean> save(@RequestBody Dept dept) {
        boolean save = deptService.save(dept);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }
    
    @PutMapping
    @ApiOperation("保存部门")
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
