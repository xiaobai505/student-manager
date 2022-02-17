package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.service.CourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping ("/page")
    public Object page(@RequestBody Page page) {
        return courseService.page(page);
    }

    @GetMapping  ("/list")
    public List list(@RequestParam(value = "isMust",defaultValue= "false") Boolean isMust){
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Course::getIsMust,isMust);
        return courseService.list(wrapper);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean saveOrUpdate(@RequestBody Course course){
        return courseService.saveOrUpdate(course);
    }

    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable Long id){
        return courseService.removeById(id);
    }
}
