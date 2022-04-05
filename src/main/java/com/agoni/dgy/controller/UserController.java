package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.service.UserService;
import com.agoni.security.utils.UserUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ApiOperation("获取用户")
    public AuthUserVo get(){
        AuthUserVo userPrincipal = UserUtil.getUserPrincipal();
        return userPrincipal;
    }

    @GetMapping("/page")
    @ApiOperation("用户列表")
    public ResponseEntity<IPage> pageUser(@RequestParam(value = "pageSize") Long Size,
                                       @RequestParam(value = "currentPage") Long current,
                                       @RequestParam(value = "name",defaultValue = "") String name,
                                       @RequestParam(value = "roles",defaultValue = "") String roles){
        UserAndRole userAndRole = UserAndRole.builder().name(name).roles(roles).build();
        Page<UserAndRole> page =new Page<>();
        page.setSize(Size);
        page.setCurrent(current);
        IPage<UserAndRole> res = userService.selectpage(page, userAndRole);
        return new ResponseEntity<IPage>(res, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("新增用户")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<User> user){
        boolean b = userService.saveBatch(user);
        return new ResponseEntity<Boolean>(b, HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation("更新用户")
    public ResponseEntity<Boolean> updateBatchById(@RequestBody List<User> user){
        boolean b = userService.updateBatchById(user);
        return new ResponseEntity<Boolean>(b, HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation("更新用户")
    public ResponseEntity<Boolean> removeByIds(@RequestBody List<User> userList){
        List<Long> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        boolean b = userService.removeByIds(ids);
        return new ResponseEntity<Boolean>(b, HttpStatus.OK);
    }
}
