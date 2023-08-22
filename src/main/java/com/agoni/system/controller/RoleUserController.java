package com.agoni.system.controller;


import com.agoni.system.model.response.ResponseEntity;
import com.agoni.system.model.vo.RoleUserVo;
import com.agoni.system.service.RoleUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色关系表 前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/sys/roleUser")
@Slf4j
@Api(tags="角色权限关联")
public class RoleUserController {
    
    @Autowired
    private RoleUserService roleUserService;
    
    @GetMapping("/{userId}")
    @ApiOperation("根据用户ID获取角色信息")
    public ResponseEntity<List<Long>> getByUserId(@PathVariable @NotNull Long userId) {
        List<RoleUserVo> roleUserVos = roleUserService.getRolebyUserId(userId);
        List<Long> ids = roleUserVos.stream().map(RoleUserVo::getRoleId).collect(Collectors.toList());
        return ResponseEntity.body(ids);
    }
    
    @PostMapping("/{userId}")
    @ApiOperation("根据用户ID添加角色信息")
    public ResponseEntity<Boolean> saveByUserId(@PathVariable @NotNull Long userId , @RequestBody @NotEmpty List<Long> ids) {
        boolean b = roleUserService.saveByUserId(userId,ids);
        return ResponseEntity.body(b);
    }
    
}
