package com.agoni.system.controller;

import com.agoni.system.model.po.Logininfor;
import com.agoni.system.model.query.LogininforQuery;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.service.LogininforService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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
        queryWrapper.lambda()
                    .eq(StringUtils.isNotEmpty(query.getUserName()), Logininfor::getUserName, query.getUserName())
                    .orderByAsc(Logininfor::getLoginTime);
        Page<Logininfor> page = logininforService.page(query, queryWrapper);
        return ResponseEntity.body(page);
    }
    
    @GetMapping("/page1")
    @ApiOperation("分页列表")
    public ResponseEntity<String> page() {
        return ResponseEntity.body("ok");
    }
}
