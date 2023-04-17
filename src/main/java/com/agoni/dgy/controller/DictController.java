package com.agoni.dgy.controller;

import com.agoni.core.Binder;
import com.agoni.dgy.model.po.Dict;
import com.agoni.dgy.model.vo.DictVo;
import com.agoni.dgy.service.DictService;
import com.agoni.system.response.ResponseEntity;
import com.diboot.core.util.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
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
    
    @GetMapping("/test")
    @ApiOperation("列表")
    public ResponseEntity<List<DictVo>> get(){
        List<Dict> list = dictService.list();
        List<DictVo> voList = Binder.convertAndBindRelations(list, DictVo.class);
        List<DictVo> dicts = BeanUtils.buildTree(voList);
        return ResponseEntity.body(dicts);
    }
    
    @GetMapping
    @ApiOperation("列表")
    @Cacheable(value = "dict", key = "#root.methodName")
    public ResponseEntity<List<Dict>> list() {
        List<Dict> list = dictService.list();
        return ResponseEntity.body(list);
    }
    
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Boolean> save(@RequestBody Dict dict) {
        boolean res = dictService.save(dict);
        return ResponseEntity.body(res);
    }
    
    @PutMapping
    @ApiOperation("更新")
    public ResponseEntity<Boolean> update(@RequestBody Dict dict) {
        boolean res = dictService.updateById(dict);
        return ResponseEntity.body(res);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResponseEntity<Boolean> del(@PathVariable long id) {
        boolean res = dictService.del(id);
        return ResponseEntity.body(res);
    }
    
    
}
