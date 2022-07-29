package com.agoni.dgy.controller;

import com.agoni.dgy.model.po.Dict;
import com.agoni.dgy.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gyd
 */
@RestController
@RequestMapping("/dgy/dict")
@Api(tags = "字典")
public class DictController {
    
    @Autowired
    private DictService dictService;
    
    @GetMapping
    @ApiOperation("获取角色信息集合")
    public ResponseEntity<List<Dict>> list() {
        List<Dict> list = dictService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping
    @ApiOperation("获取角色信息集合")
    public ResponseEntity<Boolean> save(@RequestBody Dict dict) {
        boolean res = dictService.save(dict);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PutMapping
    @ApiOperation("获取角色信息集合")
    public ResponseEntity<Boolean> update(@RequestBody Dict dict) {
        boolean res = dictService.updateById(dict);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("获取角色信息集合")
    public ResponseEntity<Boolean> del(@PathVariable long id) {
        boolean res = dictService.del(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    
}