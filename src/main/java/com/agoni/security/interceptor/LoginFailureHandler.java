package com.agoni.security.interceptor;

import com.agoni.system.config.enums.ResponseCodeEnum;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.service.LogininforService;
import com.alibaba.fastjson2.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败
 * @author Admin
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    
    public static final String LOGIN_FAILURE = "登录失败";
    @Resource
    private LogininforService logininforService;
    
    /**
     * Called when an authentication attempt fails.
     *
     * @param request   the request during which the authentication attempt occurred.
     * @param response  the response.
     * @param exception the exception which was thrown to reject the authentication
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.getWriter().write(JSON.toJSONString(ResponseEntity.body(ResponseCodeEnum.LOGIN_FAILURE)));
        logininforService.asyncLogininfor("***", "1", LOGIN_FAILURE);
        
    }
}
