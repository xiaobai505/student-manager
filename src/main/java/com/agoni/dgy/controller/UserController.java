package com.agoni.dgy.controller;


import com.agoni.dgy.model.bo.AddUserFrom;
import com.agoni.dgy.model.from.FromPage;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.service.UserService;
import com.agoni.security.utils.UserUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ApiOperation("新增用户")
    public void saveOrUpdate(@RequestBody User user){
        userService.saveOrUpdate(user);
    }

    @PostMapping("/selectPage")
    @ApiOperation("分页/条件获取用户")
    public IPage<UserAndRole> selectPage(@RequestBody FromPage from) {
        AuthUserVo authUser = UserUtil.getUserPrincipal();
        log.info("AuthUserVo------------"+authUser.getUsername());
        return userService.selectpage(from.getPage(), from.getUserAndRole());
    }
}
