package com.agoni.system.controller;

import com.agoni.core.omp.OmpDbUtil;
import com.agoni.system.model.po.Logininfor;
import com.agoni.system.model.query.LogininforQuery;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.service.LogininforService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dgy/logininfor")
@Slf4j
@Api(tags="课程")
public class LogininforController {
    
    @Autowired
    private LogininforService logininforService;
    
    
    @GetMapping("/page")
    @ApiOperation("分页列表")
    public ResponseEntity<Page> page(@Validated LogininforQuery query) {
        QueryWrapper<Logininfor> queryWrapper = new QueryWrapper<>();
        fillQueryWrapper(query, queryWrapper);
        Page<Logininfor> page = Page.of(query.getPage(), query.getLimit());
        Page<Logininfor> records = logininforService.page(page, queryWrapper);
        return ResponseEntity.body(records);
    }

    private static void fillQueryWrapper(LogininforQuery query, QueryWrapper<Logininfor> queryWrapper) {
        //自动组装查询条件，生成orderBy，组装条件的两种方式：1.基于注解 2.基于query对象中属性的后缀
        OmpDbUtil.autoWrapper(query, queryWrapper, Logininfor.class);
    }

    @GetMapping("/page1")
    @ApiOperation("分页列表")
    public ResponseEntity<String> page() {
        return ResponseEntity.body("ok");
    }
}
