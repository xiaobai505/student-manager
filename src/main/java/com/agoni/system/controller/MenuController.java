package com.agoni.system.controller;

import com.agoni.system.model.response.ResponseEntity;
import com.agoni.system.model.vo.MenuTreeVo;
import com.agoni.system.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Admin
 */
@RestController
@RequestMapping("/sys/menu")
@Slf4j
@Api(tags = "动态路由")
public class MenuController {
    
    @Resource
    private MenuService menuService;
    
    @GetMapping("/getAsyncRoutes")
    @ApiOperation("当前用户菜单")
    public ResponseEntity<List<MenuTreeVo>> get() {
        List<MenuTreeVo> tree = menuService.getTree();
        return ResponseEntity.body(tree);
    }
}
