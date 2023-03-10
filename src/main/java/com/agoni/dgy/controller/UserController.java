package com.agoni.dgy.controller;


import com.agoni.core.Binder;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.query.PwdQuery;
import com.agoni.dgy.model.query.UserQuery;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.model.vo.UserVo;
import com.agoni.dgy.service.UserService;
import com.agoni.system.utils.UserUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 dgy前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/dgy/user")
@Slf4j
@Api(tags="用户")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation("获取当前登录用户")
    public ResponseEntity<UserVo> get(){
        User user = UserUtil.getUser();
        UserVo userVo = Binder.convertAndBindRelations(user, UserVo.class);
        return new ResponseEntity<>(userVo, HttpStatus.OK);
    }

    @GetMapping("/page")
    @ApiOperation("列表")
    public ResponseEntity<IPage> page(@Validated UserQuery userQuery){
        IPage<UserAndRole> res = userService.pageUser(userQuery);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("新增")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<User> user){
        boolean b = userService.saveBatch(user);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation("更新")
    public ResponseEntity<Boolean> updateBatchById(@RequestBody List<User> user){
        boolean b = userService.updateBatchById(user);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation("删除")
    public ResponseEntity<Boolean> removeByIds(@RequestBody List<User> userList){
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        boolean b = userService.removeByIds(ids);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
    
    @PutMapping("/resetPwd")
    @ApiOperation("更新密码")
    public ResponseEntity<Boolean> resetPwd(@RequestBody PwdQuery pq){
        boolean b = userService.resetPwd(pq);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
}
