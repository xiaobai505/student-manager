package com.agoni.system.controller;

import com.agoni.system.model.po.Logininfor;
import com.agoni.system.model.query.LogininforPageQuery;
import com.agoni.system.model.response.ResponseEntity;
import com.agoni.system.service.LogininforService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gyd
 */
@RestController
@RequestMapping("/sys/logininfor")
@Slf4j
@Api(tags="登录日志")
public class LogininforController {
    
    @Resource
    private LogininforService logininforService;
    
    
    @GetMapping
    @ApiOperation("分页列表")
    public ResponseEntity<Page<Logininfor>> page(@Validated LogininforPageQuery query) {
        Page<Logininfor> page = logininforService.selectPage(query);
        return ResponseEntity.body(page);
    }

}
