package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.query.CourseQuery;
import com.agoni.dgy.model.vo.CourseVo;
import com.agoni.dgy.service.CourseService;
import com.agoni.system.model.response.ResponseEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
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
@Api(tags="课程")
//@PreAuthorize("hasRole('ROLE_TEACHER')")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @GetMapping("/list")
    @ApiOperation("列表")
    @Cacheable(value = "courselist", key = "#root.methodName")
    public List<Course> list() {
        List<Course> list = courseService.list();
        return list;
    }
    
    @GetMapping
    @ApiOperation("列表")
    public ResponseEntity<IPage> searchPage(@Validated CourseQuery from) {
        IPage<CourseVo> res = courseService.selectPage(from);
        return ResponseEntity.body(res);
    }
    
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Boolean> save(@RequestBody Course course) {
        boolean b = courseService.saveOrUpdate(course);
        return ResponseEntity.body(b);
    }
    
    @PutMapping
    @ApiOperation("更新")
    public ResponseEntity<Boolean> updateById(@RequestBody Course course) {
        boolean b = courseService.updateById(course);
        return ResponseEntity.body(b);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResponseEntity<Boolean> delete(@PathVariable long id){
        boolean b = courseService.removeById(id);
        return ResponseEntity.body(b);
    }
}
