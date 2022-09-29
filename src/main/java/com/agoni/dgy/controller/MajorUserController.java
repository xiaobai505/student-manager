package com.agoni.dgy.controller;

import com.agoni.dgy.model.po.MajorUser;
import com.agoni.dgy.service.MajorUserService;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dgy/majorUser")
@Api(tags="专业学生关联信息")
public class MajorUserController {
    
    @Autowired
    private MajorUserService majorUserService;
    
    /**
     * 可以根据用户id查找专业，也可以根据专业ID查找用户
     * @param mu
     *
     * @return
     */
    @GetMapping
    @ApiOperation("根据 MajorUser 查找对应关系")
    public ResponseEntity<List> getByMajorId(@Validated MajorUser mu) {
        List<MajorUser> getlist = majorUserService.getlist(mu);
        List<Long> collect = getlist.stream().map(MajorUser::getUserId).collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.OK);
    }
}
