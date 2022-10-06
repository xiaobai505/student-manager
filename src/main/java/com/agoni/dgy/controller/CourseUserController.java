package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.model.query.CourseUserQuery;
import com.agoni.dgy.model.vo.CourseUserVo;
import com.agoni.dgy.service.CourseUserService;
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

/**
 * <p>
 * 用户课程关系表 前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/dgy/courseUser")
@Slf4j
@Api(tags="课程与用户关系")
public class CourseUserController {

    @Autowired
    private CourseUserService courseUserService;
    
    @GetMapping
    @ApiOperation("列表")
    public ResponseEntity<IPage> searchPage(@Validated CourseUserQuery cq) {
        IPage<CourseUserVo> res = courseUserService.searchPage(cq);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Boolean> save(@RequestBody Course course) {
        boolean b = courseUserService.saveCourse(course.getId());
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @PutMapping
    @ApiOperation("更新")
    public ResponseEntity<Boolean> updateBatchById(@RequestBody List<CourseUser> courseUserList) {
        boolean b = courseUserService.updateBatchById(courseUserList);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @DeleteMapping
    @ApiOperation("删除")
    public ResponseEntity<Boolean> delete(@RequestBody CourseUser courseUser){
        boolean b = courseUserService.deleteById(courseUser);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

}
