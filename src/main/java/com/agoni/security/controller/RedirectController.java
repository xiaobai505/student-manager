package com.agoni.security.controller;

import com.agoni.dgy.model.po.User;
import com.agoni.security.utils.JwtTokenUtil;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
public class RedirectController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/getToken")
    public String getToken(@RequestBody User user) {
        if (StringUtils.equals("admin", user.getUsername())) {
            String token = jwtTokenUtil.generateToken(user.getUsername());
            return token;
        }
        return null;
    }

    @GetMapping("/checkToken")
    public boolean checkToken(HttpServletRequest request){
        try {
            String token = request.getHeader("token");
//            jwtTokenUtil.getAllClaimsFromToken(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
