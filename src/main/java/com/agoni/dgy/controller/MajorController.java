package com.agoni.dgy.controller;


import com.agoni.dgy.model.bo.MajorSearchFrom;
import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.service.MajorService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    
    
    @GetMapping
    public ResponseEntity<IPage> searchPage(@Validated MajorSearchFrom from) {
        IPage<Major> res = majorService.searchPage(from);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody List<Major> major) {
        boolean b = majorService.saveBatch(major);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Boolean> updateBatchById(@RequestBody List<Major> majorList) {
        boolean b = majorService.updateBatchById(majorList);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity<Boolean>  delete(@RequestBody List<Major> majorList){
        List<Long> ids = majorList.stream().map(Major::getId).collect(Collectors.toList());
        boolean b = majorService.removeByIds(ids);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id){
        return majorService.removeById(id);
    }
    
}
