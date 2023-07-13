package com.agoni.security.interceptor;

import com.agoni.security.config.constants.JwtConfiguration;
import com.agoni.security.model.TokenVo;
import com.agoni.security.service.AuthUserService;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.service.LogininforService;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * @author gyd
 */
@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    public static final String LOGIN_SUCCESS = "登录成功";
    @Resource
    private JwtConfiguration jwtConfiguration;
    @Resource
    private LogininforService logininforService;
    @Resource
    private AuthUserService authUserService;

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
        String userName = principal.getUsername();
        // multipleLogin为true时,每次登录成功后产生一个新的clientId,如果为false,则clientId都为0
        String clientId = jwtConfiguration.getMultipleLogin() ? IdWorker.getIdStr() : "0";
        TokenVo tokenVo = authUserService.getTokenVo(userName, clientId);
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(JSON.toJSONString(ResponseEntity.body(tokenVo)));
        // 登录成功记录
        logininforService.asyncLogininfor(principal.getUsername(), "0", LOGIN_SUCCESS);
    }
}
