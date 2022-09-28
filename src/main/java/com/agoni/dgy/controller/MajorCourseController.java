package com.agoni.dgy.controller;

import com.agoni.dgy.model.po.MajorCourse;
import com.agoni.dgy.service.MajorCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dgy/majorCourse")
@Api(tags="专业课程关联信息")
public class MajorCourseController {
    
    @Autowired
    private MajorCourseService majorCourseService;
    
    
    @GetMapping
    @ApiOperation("列表")
    public ResponseEntity<List> getByMajorId(@Validated MajorCourse from) {
        List<MajorCourse> majorCourses = majorCourseService.getByMajorId(from.getMajorId());
        List<Long> collect = majorCourses.stream().map(MajorCourse::getCourseId).collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.OK);
    }
    
    @PostMapping("/{majorId}")
    @ApiOperation("根据用户ID添加角色信息")
    public ResponseEntity<Boolean> setCoursesByMajorId(@PathVariable @NotNull Long majorId , @RequestBody @NotEmpty List<Long> ids) {
        boolean b = majorCourseService.setCoursesByMajorId(majorId, ids);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

}
