package com.agoni.dgy.controller;


import com.agoni.dgy.model.bo.ResultSearchFrom;
import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.model.vo.ResultVo;
import com.agoni.dgy.service.ResultService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 成绩表 前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/dgy/result")
public class ResultController {

    @Autowired
    private ResultService resultService;
    
    @GetMapping
    public ResponseEntity<IPage> searchPage(@Validated ResultSearchFrom from) {
        IPage<ResultVo> res = resultService.searchPage(from);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody List<Result> resultList) {
        boolean b = resultService.saveBatch(resultList);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Boolean> updateBatchById(@RequestBody List<Result> resultList) {
        boolean b = resultService.updateBatchById(resultList);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity<Boolean>  delete(@RequestBody List<Result> resultList){
        List<Long> ids = resultList.stream().map(Result::getId).collect(Collectors.toList());
        boolean b = resultService.removeByIds(ids);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id){
        return resultService.removeById(id);
    }
}
