package com.agoni.security.controller;

import com.agoni.dgy.model.from.FromPage;
import com.agoni.dgy.model.vo.UserAndRole;
import com.agoni.security.utils.JwtTokenUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class RedirectController {


    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/get")
    public void selectPage(@RequestBody FromPage from) {
    }
}
