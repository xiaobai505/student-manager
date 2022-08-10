package com.agoni.system.controller;

import com.agoni.dgy.model.vo.MenuTreeVo;
import com.agoni.dgy.service.MenuService;
import com.agoni.dgy.service.MeunRoleService;
import com.agoni.system.utils.UserUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private MeunRoleService meunRoleService;
    
    @GetMapping("/getAsyncRoutes/{userName}")
    @ApiOperation("获取用户")
    public ResponseEntity<List> get(@PathVariable String userName) {
        String code = UserUtil.getFirstRole();
        if (StringUtils.isEmpty(code)){
            return null;
        }
        List<MenuTreeVo> tree = menuService.getTree(code);
        return new ResponseEntity<>(tree, HttpStatus.OK);
    }
}
