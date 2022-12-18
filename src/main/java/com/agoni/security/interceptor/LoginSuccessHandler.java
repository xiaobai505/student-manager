package com.agoni.security.interceptor;

import com.agoni.dgy.service.LogininforService;
import com.agoni.security.constants.SecurityConstants;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.response.ResponseEntity;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author gyd
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    
    @Value("${JWT.multipleLogin}")
    private boolean multipleLogin;
    
    public static final String loginSuccess = "登录成功";
    @Autowired
    private LogininforService logininforService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    
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
    
        // 保存用户信息到redis
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String username = principal.getUsername();
        // multipleLogin为true时,每次登录成功后产生一个新的clientId,如果为false,则clientId都为0
        HashMap<String, Object> tokenMap = getTokenMap(username, multipleLogin ? IdWorker.getIdStr() : "0");
        List roles=new ArrayList();
        roles.add("admin");
        tokenMap.put("roles",roles);
        tokenMap.put("expires","2023/10/30 00:00:00");
    
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(JSON.toJSONString(ResponseEntity.body(tokenMap)));
    
        logininforService.asyncLogininfor(principal.getUsername(), "0", loginSuccess,request);
    }
    
    /**
     * @param username 用户名
     * @param clientId 新的clientId
     *
     * @return
     */
    HashMap<String, Object> getTokenMap(String username,String clientId){
        HashMap<String, Object> map = new HashMap<>(8);
        map.put("username",username);
        String accessToken = jwtTokenUtil.generateToken(username,clientId);
        String refreshToken = jwtTokenUtil.generateToken(SecurityConstants.REFRESH_TOKEN + ":" + username, clientId);
        map.put(SecurityConstants.ACCESS_TOKEN, accessToken);
        map.put(SecurityConstants.REFRESH_TOKEN, refreshToken);
        return map;
    }
    
}
