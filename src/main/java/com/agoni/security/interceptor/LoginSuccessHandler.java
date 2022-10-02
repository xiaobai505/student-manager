package com.agoni.security.interceptor;

import com.agoni.dgy.service.LogininforService;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.exception.ExceptionResponse;
import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gyd
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    
    public static final String loginSuccess = "登录成功";
    @Autowired
    private LogininforService logininforService;
    
    /**
     * Called when a user has been successfully authenticated.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String token = JwtTokenUtil.generateToken(principal.getUsername());
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(JSON.toJSONString(ExceptionResponse.body(token)));
    
        logininforService.asyncLogininfor(principal.getUsername(), "0", loginSuccess,request);
    }
    
}
