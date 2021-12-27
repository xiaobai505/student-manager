package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.service.MajorService;
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
 * @since 2021-12-27
 */
@RestController
@RequestMapping("/dgy/major")
@CrossOrigin
public class MajorController {

    @Autowired
    private MajorService majorService;

    @GetMapping("/list")
    public List<Major> list() {
        return majorService.list();
    }

    @GetMapping("/page")
    public Page page(@RequestBody Page page) {
        return majorService.page(page);
    }

}
