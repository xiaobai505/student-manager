package com.agoni.dgy.controller;

import com.agoni.dgy.model.TbClass;
import com.agoni.dgy.service.TbCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class Test {

    @Autowired
    private TbCourseService tbCourseService;

    @RequestMapping("/test/{id}")
    public TbClass test(@PathVariable("id") int id){
        TbClass tbClass = tbCourseService.selectByPrimaryKey(id);
        return tbClass;
    }
}
