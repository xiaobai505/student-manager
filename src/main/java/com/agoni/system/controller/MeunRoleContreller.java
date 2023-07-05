package com.agoni.system.controller;

import com.agoni.system.model.po.MeunRole;
import com.agoni.system.service.MeunRoleService;
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

@RestController
@RequestMapping("/sys/meunRole")
@Api(tags="菜单角色关联")
public class MeunRoleContreller {
    
    @Autowired
    private MeunRoleService meunRoleService;
    
    @GetMapping
    @ApiOperation("根据 角色id 查询 菜单ids")
    public ResponseEntity<List> getByMajorId(@Validated MeunRole mr) {
        List<MeunRole> getlist = meunRoleService.getlist(mr);
        return new ResponseEntity<>(getlist, HttpStatus.OK);
    }
    
}
