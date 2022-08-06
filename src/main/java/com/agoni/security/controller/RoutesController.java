package com.agoni.security.controller;

import com.agoni.core.Binder;
import com.agoni.dgy.model.po.Menutree;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.dgy.model.vo.MenutreeVo;
import com.agoni.dgy.service.MenutreeService;
import com.agoni.security.utils.UserUtil;
import com.diboot.core.util.BeanUtils;
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
    private MenutreeService menutreeService;
    
    @GetMapping("/getAsyncRoutes/{userName}")
    @ApiOperation("获取用户")
    public ResponseEntity<List> get(@PathVariable String userName) {
        AuthUserVo userPrincipal = UserUtil.getUserPrincipal();
        List<Menutree> list = menutreeService.list();
        List<MenutreeVo> tree = BeanUtils.buildTree(Binder.convertAndBindRelations(list, MenutreeVo.class));
        return new ResponseEntity<>(tree, HttpStatus.OK);
    }
}
