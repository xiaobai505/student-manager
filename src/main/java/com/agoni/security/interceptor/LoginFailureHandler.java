package com.agoni.security.interceptor;

import com.agoni.dgy.service.LogininforService;
import com.agoni.system.response.ResponseCodeEnum;
import com.agoni.system.response.ResponseEntity;
import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败
 * @author Admin
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    
    public static final String loginFailure = "登录失败";
    @Autowired
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
        logininforService.asyncLogininfor("***", "1", loginFailure,request);
        
    }
}
