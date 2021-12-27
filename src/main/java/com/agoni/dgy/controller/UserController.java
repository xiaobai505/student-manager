package com.agoni.dgy.controller;


import com.agoni.dgy.model.from.FromPage;
import com.agoni.dgy.model.from.UserAndRoleFrom;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
    @RequestMapping("/updateById")
    public boolean updateById(@RequestBody User user) {
        return userService.updateById(user);
    }

    public void saveUserAndRole(@RequestBody UserAndRoleFrom userAndRole){
        userService.saveUserAndRole(userAndRole);
    }
}
