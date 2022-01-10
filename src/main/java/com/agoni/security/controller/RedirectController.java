package com.agoni.security.controller;

import com.agoni.dgy.model.po.User;
import com.agoni.security.constants.SecurityConstants;
import com.agoni.security.utils.JwtTokenUtil;
import com.alibaba.druid.util.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class RedirectController {


    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (StringUtils.equals("admin", user.getUsername())) {
            String token = JwtTokenUtil.generateToken(user.getUsername());
            return token;
        }
        return null;
    }

    @GetMapping("/checkToken")
    public boolean checkToken(HttpServletRequest request){
        try {
            String token = request.getHeader("token");
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
