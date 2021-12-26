package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.Class;
import com.agoni.dgy.service.ClassService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 班级表 前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/dgy/class")
@CrossOrigin
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/list")
    public List<Class> list() {
        return classService.list();
    }

    @PostMapping("/page")
    public IPage<Class> page(Page page) {
        QueryWrapper queryWrapper=new QueryWrapper();
        return classService.page(page,queryWrapper);
    }

    @GetMapping("/selectPage")
    public void selectpage(Page page){
        classService.selectpage();
    }
}
