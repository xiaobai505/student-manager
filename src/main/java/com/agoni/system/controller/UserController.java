package com.agoni.system.controller;


import com.agoni.core.diboot.Binder;
import com.agoni.dgy.model.query.PwdQuery;
import com.agoni.system.model.po.User;
import com.agoni.system.model.query.UserQuery;
import com.agoni.system.model.response.ResponseEntity;
import com.agoni.system.model.vo.UserVo;
import com.agoni.system.service.UserService;
import com.agoni.system.utils.UserUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 dgy前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/sys/user")
@Slf4j
@Api(tags="用户")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    @ApiOperation("获取当前登录用户")
    public ResponseEntity<UserVo> get(){
        User user = UserUtil.getUser();
        UserVo userVo = Binder.convertAndBindRelations(user, UserVo.class);
        return ResponseEntity.body(userVo);
    }

    @GetMapping("/page")
    @ApiOperation("列表")
    public ResponseEntity<IPage> page(@Validated UserQuery userQuery){
        IPage<UserVo> res = userService.pageUser(userQuery);
        return ResponseEntity.body(res);
    }

    @PostMapping
    @ApiOperation("新增")
    public ResponseEntity<Boolean> saveOrUpdate(@RequestBody User user){
        user.setPassword("admin123");
        boolean b = userService.saveOrUpdate(user);
        return ResponseEntity.body(b);
    }

    @PutMapping
    @ApiOperation("更新")
    public ResponseEntity<Boolean> updateBatchById(@RequestBody User user){
        boolean b = userService.updateById(user);
        return ResponseEntity.body(b);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResponseEntity<Boolean> removeById(@PathVariable long id){
        boolean b = userService.removeById(id);
        return ResponseEntity.body(b);
    }
    
    @PutMapping("/resetPwd")
    @ApiOperation("重置密码")
    public ResponseEntity<Boolean> resetPwd(@RequestBody PwdQuery pq){
        boolean b = userService.resetPwd(pq);
        return ResponseEntity.body(b);
    }
}
