package com.agoni.system.controller;

import com.agoni.system.model.po.DictConfig;
import com.agoni.system.service.DictConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/dictConfig")
@Api(tags = "字典")
public class DictConfigController {
    
    @Autowired
    private DictConfigService dictConfigService;
    
    @GetMapping("/{id}")
    @ApiOperation("列表")
    public ResponseEntity<List<DictConfig>> list(@PathVariable long id) {
        List<DictConfig> list = dictConfigService.getDictId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Boolean> save(@RequestBody DictConfig dictConfig) {
        boolean res = dictConfigService.save(dictConfig);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PutMapping
    @ApiOperation("更新")
    public ResponseEntity<Boolean> update(@RequestBody DictConfig dictConfig) {
        boolean res = dictConfigService.updateById(dictConfig);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResponseEntity<Boolean> del(@PathVariable long id) {
        boolean res = dictConfigService.removeById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
