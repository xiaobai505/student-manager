package com.agoni.dgy.controller;


import com.agoni.dgy.model.bo.CourseSearchFrom;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.service.CourseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @GetMapping
    public ResponseEntity<IPage> coursePage(@Validated CourseSearchFrom from) {
        IPage<Major> res = courseService.majorPage(from);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody List<Course> courses) {
        boolean b = courseService.saveBatch(courses);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Boolean> updateBatchById(@RequestBody List<Course> courses) {
        boolean b = courseService.updateBatchById(courses);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity<Boolean>  delete(@RequestBody List<Course> courses){
        List<Long> ids = courses.stream().map(Course::getId).collect(Collectors.toList());
        boolean b = courseService.removeByIds(ids);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id){
        return courseService.removeById(id);
    }
}
