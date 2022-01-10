package com.agoni.dgy.controller;


import com.agoni.dgy.model.from.AddUserFrom;
import com.agoni.dgy.model.from.FromPage;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询多表关联用户信息
     * @param from
     * @return
     */
    @PostMapping("/selectPage")
    public IPage<UserAndRole> selectPage(@RequestBody FromPage from) {
        return userService.selectpage(from.getPage(), from.getUserAndRole());
    }


    /**
     * 根据id更新用户信息
     * @param user
     * @return
     */
    @PostMapping("/updateById")
    public boolean updateById(@RequestBody User user) {
        return userService.updateById(user);
    }

    /**
     * 新增用户 user role major 信息
     * @param addUserFrom
     */
    @PostMapping("/addUser")
    public void addUser(@RequestBody AddUserFrom addUserFrom){
        userService.saveUserAndRole(addUserFrom);
    }
}
