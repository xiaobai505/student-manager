package com.agoni.dgy.controller;


import com.agoni.dgy.model.bo.CourseSearchFrom;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.vo.CourseVo;
import com.agoni.dgy.service.CourseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 课程表 前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/dgy/course")
@Slf4j
@Api(tags="课程")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @GetMapping("/list")
    @ApiOperation("列表")
    public ResponseEntity<List<Course>> list() {
        List<Course> list = courseService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping
    @ApiOperation("列表")
    public ResponseEntity<IPage> searchPage(@Validated CourseSearchFrom from) {
        IPage<CourseVo> res = courseService.searchPage(from);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Boolean> save(@RequestBody List<Course> courses) {
        boolean b = courseService.saveBatch(courses);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @PutMapping
    @ApiOperation("更新")
    public ResponseEntity<Boolean> updateBatchById(@RequestBody List<Course> courses) {
        boolean b = courseService.updateBatchById(courses);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @DeleteMapping
    @ApiOperation("删除")
    public ResponseEntity<Boolean>  delete(@RequestBody List<Course> courses){
        List<Long> ids = courses.stream().map(Course::getId).collect(Collectors.toList());
        boolean b = courseService.removeByIds(ids);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
}
