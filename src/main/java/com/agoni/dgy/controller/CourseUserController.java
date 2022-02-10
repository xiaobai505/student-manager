package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.model.vo.CourseUserVo;
import com.agoni.dgy.service.CourseUserService;
import com.agoni.security.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/dgy/course-user")
@Slf4j
public class CourseUserController {

    @Autowired
    private CourseUserService courseUserService;

    @GetMapping("/list")
    public List<CourseUser> list(){
        return courseUserService.list();
    }

    @GetMapping("/mylist")
    public List<CourseUserVo> mylist(){
        return courseUserService.mylist();
    }


    @PostMapping("/saveOrUpdate")
    public Boolean saveOrUpdate(@RequestBody CourseUser courseUser) {
        log.info("courseUser.getId:" + courseUser.getId());
        Long userId = UserUtil.getUserPrincipal().getId();
        courseUser.setUserId(userId);
        boolean res = courseUserService.saveOrUpdate(courseUser);
        return res;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        boolean res = courseUserService.removeById(id);
        return res;
    }

}
