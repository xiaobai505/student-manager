package com.agoni.dgy.controller;


import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.service.CourseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/page")
    public IPage<UserAndRole> page(@RequestBody Page page) {
        return courseService.page(page);
    }
}
