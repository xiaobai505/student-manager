package com.agoni.system.controller;

import com.agoni.core.diboot.Binder;
import com.agoni.system.model.po.Dict;
import com.agoni.system.model.vo.DictVo;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.service.DictService;
import com.diboot.core.util.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
