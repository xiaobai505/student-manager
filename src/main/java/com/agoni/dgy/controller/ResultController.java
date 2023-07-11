package com.agoni.dgy.controller;


import com.agoni.core.thread.ExecutorConfig;
import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.model.query.ResultQuery;
import com.agoni.dgy.model.vo.ResultVo;
import com.agoni.dgy.service.ResultService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
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
@Api(tags="成绩")
@Slf4j
public class ResultController {

    @Autowired
    private ResultService resultService;
    
    @Autowired
    private ExecutorConfig executorConfig;
    
    //@GetMapping("/test")
    @ApiOperation("测试")
    public ResponseEntity<Object> test() {
        long start = System.currentTimeMillis();
        //extracted3();
        printimeAndThread("耗时:"+ (System.currentTimeMillis() - start));
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    
    private void extracted3() {
        CompletableFuture<String> futureA = resultService.test(5);
        CompletableFuture<String> futureB = resultService.test(2);
        String join = futureA.thenCombine(futureB, (resultA, resultB) -> resultA + ";" + resultB).join();
        printimeAndThread("join:" + join);
    }
    
    
    public static void printimeAndThread(String tag){
        String res=new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(res);
    }
    
    
    @GetMapping
    @ApiOperation("列表")
    public ResponseEntity<IPage> searchPage(@Validated ResultQuery from) {
        IPage<ResultVo> res = resultService.searchPage(from);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Boolean> save(@RequestBody List<Result> resultList) {
        boolean b = resultService.saveBatch(resultList);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @PutMapping
    @ApiOperation("删除")
    public ResponseEntity<Boolean> updateBatchById(@RequestBody List<Result> resultList) {
        boolean b = resultService.updateBatchById(resultList);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @DeleteMapping
    @ApiOperation("删除")
    public ResponseEntity<Boolean>  delete(@RequestBody List<Result> resultList){
        List<Long> ids = resultList.stream().map(Result::getId).collect(Collectors.toList());
        boolean b = resultService.removeByIds(ids);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public boolean deleteById(@PathVariable Long id){
        return resultService.removeById(id);
    }
}
