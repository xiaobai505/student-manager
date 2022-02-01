package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.dgy.service.CourseUserService;
import com.agoni.security.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public List list(){
        return courseUserService.list();
    }

    @PostMapping("/saveOrUpdate")
    public Boolean saveOrUpdate(@RequestBody CourseUser courseUser) {
        log.info("courseUser.getId:" + courseUser.getId());
        Long userId = UserUtil.getUserPrincipal().getId();
        courseUser.setUserId(userId);
        boolean res = courseUserService.saveOrUpdate(courseUser);
        return res;
    }

}
