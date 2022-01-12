package com.agoni.security.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class RedirectController {

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
