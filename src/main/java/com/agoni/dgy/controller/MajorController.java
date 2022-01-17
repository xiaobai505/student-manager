package com.agoni.dgy.controller;


import com.agoni.dgy.model.from.FromPage;
import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.service.MajorService;
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
 * @since 2022-01-04
 */
@RestController
@RequestMapping("/dgy/major")
public class MajorController {

    @Autowired
    private MajorService majorService;

    @PostMapping("/page")
    public IPage<UserAndRole> page(@RequestBody Page page) {
        return majorService.page(page);
    }

    @PostMapping("/selectPage")
    public IPage<UserAndRole> selectPage(@RequestBody FromPage from) {
        return null;
    }

    @PostMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody Major major) {
        return majorService.saveOrUpdate(major);
    }

    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable Long id){
        return majorService.removeById(id);
    }
}
