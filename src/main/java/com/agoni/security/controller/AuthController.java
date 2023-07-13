package com.agoni.security.controller;

import com.agoni.security.model.TokenFrom;
import com.agoni.security.model.TokenVo;
import com.agoni.security.service.AuthUserService;
import com.agoni.system.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gyd
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Resource
    private AuthUserService authUserService;

    @PostMapping("/refreshToken")
    public ResponseEntity<TokenVo> refreshToken(@Validated @RequestBody TokenFrom tokenFrom) {
        TokenVo tokenVo = authUserService.refreshToken(tokenFrom.getRefreshToken());
        return ResponseEntity.body(tokenVo);
    }



}
