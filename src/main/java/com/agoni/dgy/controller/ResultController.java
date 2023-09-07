package com.agoni.dgy.controller;


import com.agoni.core.threadExecutor.ExecutorConfig;
import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.model.query.ResultPageQuery;
import com.agoni.dgy.model.vo.ResultVo;
import com.agoni.dgy.service.ResultService;
import com.agoni.system.model.response.ResponseEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Api(tags = "成绩")
@Slf4j
public class ResultController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private ExecutorConfig executorConfig;

    @GetMapping("/test")
    @ApiOperation("测试")
    public ResponseEntity<Object> test() {
        long start = System.currentTimeMillis();
        //extracted3();
        printimeAndThread("耗时:" + (System.currentTimeMillis() - start));
        return ResponseEntity.body("ok");
    }

    private void extracted3() {
        CompletableFuture<String> futureA = resultService.test(5);
        CompletableFuture<String> futureB = resultService.test(2);
        String join = futureA.thenCombine(futureB, (resultA, resultB) -> resultA + ";" + resultB).join();
        printimeAndThread("join:" + join);
    }


    public static void printimeAndThread(String tag) {
        String res = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(res);
    }


    @GetMapping
    @ApiOperation("列表")
    public ResponseEntity<IPage> searchPage(@Validated ResultPageQuery from) {
        IPage<ResultVo> res = resultService.searchPage(from);
        return ResponseEntity.body(res);
    }

    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Boolean> save(@RequestBody Result result) {
        boolean b = resultService.saveOrUpdate(result);
        return ResponseEntity.body(b);
    }

    @PutMapping
    @ApiOperation("删除")
    @PreAuthorize("hasAuthority('teacher')")
    public ResponseEntity<Boolean> updateById(@RequestBody Result result) {
        boolean b = resultService.updateById(result);
        return ResponseEntity.body(b);
    }

    @DeleteMapping
    @ApiOperation("删除")
    public ResponseEntity<Boolean> delete(@RequestBody List<Result> resultList) {
        List<Long> ids = resultList.stream().map(Result::getId).collect(Collectors.toList());
        boolean b = resultService.removeByIds(ids);
        return ResponseEntity.body(b);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        boolean b = resultService.removeById(id);
        return ResponseEntity.body(b);
    }
}
