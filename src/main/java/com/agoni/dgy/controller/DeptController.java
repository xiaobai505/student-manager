package com.agoni.dgy.controller;

import com.agoni.dgy.model.bo.DeptSearchFrom;
import com.agoni.dgy.model.po.Dept;
import com.agoni.dgy.service.DeptService;
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
 * @author gyd
 */
@RestController
@RequestMapping("/dgy/dept")
@Api(tags = "部门")
public class DeptController {
    
    @Autowired
    private DeptService deptService;
    
    @GetMapping
    @ApiOperation("获取角色信息集合")
    public ResponseEntity<List> list(@Validated DeptSearchFrom deptSearchFrom) {
        List<Dept> list = deptService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    
}
