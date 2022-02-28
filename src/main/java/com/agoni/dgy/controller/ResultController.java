package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.service.ResultService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 成绩表 前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/{current}/{size}")
    public ResponseEntity<IPage> page(@PathVariable Integer current){
        IPage<Result> res = resultService.page(new Page(current,1));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> page(Result result){
        boolean b = resultService.saveOrUpdate(result);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> page(@PathVariable Long id){
        boolean b = resultService.removeById(id);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
}
