package com.agoni.dgy.controller;


import com.agoni.dgy.model.bo.AddUserFrom;
import com.agoni.dgy.model.from.FromPage;
import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.dgy.service.UserService;
import com.agoni.security.utils.UserUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public AuthUserVo get(){
        AuthUserVo userPrincipal = UserUtil.getUserPrincipal();
        return userPrincipal;
    }
    /**
     * 查询多表关联用户信息
     * @param from
     * @return
     */
    @PostMapping("/selectPage")
    public IPage<UserAndRole> selectPage(@RequestBody FromPage from) {
        AuthUserVo authUser = UserUtil.getUserPrincipal();
        log.info("AuthUserVo------------"+authUser.getUsername());
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
     * 新增用户 user
     * @param user
     */
    @PostMapping("/saveOrUpdate")
    public void saveOrUpdate(@RequestBody User user){
        userService.saveOrUpdate(user);
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
