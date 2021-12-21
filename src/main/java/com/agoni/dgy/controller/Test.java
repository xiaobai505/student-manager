package com.agoni.dgy.controller;

import com.agoni.dgy.model.TbClass;
import com.agoni.dgy.service.TbCourseService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.javassist.expr.NewExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/test")
public class Test {

    @Autowired
    private TbCourseService tbCourseService;

    @RequestMapping("/test/{id}")
    public TbClass test(@PathVariable("id") int id){
        TbClass tbClass = tbCourseService.selectByPrimaryKey(id);
        return tbClass;
    }

    @RequestMapping("/all")
    public PageInfo<TbClass> all(){
        PageInfo<TbClass> tbClassPageInfo = tbCourseService.selectAll();
        return tbClassPageInfo;
    }
    @RequestMapping("/all2")
    public PageInfo<TbClass> all2(){
        PageInfo<TbClass> tbClassPageInfo = tbCourseService.selectAll2();
        return tbClassPageInfo;
    }
}
