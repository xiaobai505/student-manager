package com.agoni.system.controller;

import com.agoni.dgy.model.po.Menu;
import com.agoni.dgy.model.query.MenuQuery;
import com.agoni.dgy.model.vo.MenuTreeVo;
import com.agoni.dgy.service.MenuService;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Admin
 */
@RestController
@RequestMapping("/routes")
@Slf4j
@Api(tags = "动态路由")
public class RoutesController {
    
    @Autowired
    private MenuService menuService;
    
    @GetMapping("/getAsyncRoutes")
    @ApiOperation("当前用户菜单")
    public ResponseEntity<List> get() {
        // todo 用户有多个角色，根据用户选择的一个角色查询列表
        MenuQuery build = MenuQuery.builder().code(UserUtil.getFirstRole()).build();
        List<MenuTreeVo> tree = menuService.getTree(build);
        return ResponseEntity.body(tree);
    }
    
    @GetMapping()
    @ApiOperation("菜单列表")
    public ResponseEntity<List> list() {
        List<Menu> list = menuService.list();
        return ResponseEntity.body(list);
    }
}
