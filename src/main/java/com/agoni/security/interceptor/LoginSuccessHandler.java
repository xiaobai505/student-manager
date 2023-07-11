package com.agoni.security.interceptor;

import com.agoni.core.cache.TokenCacheManger;
import com.agoni.security.config.constants.JwtConfiguration;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.service.LogininforService;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.diboot.core.util.D;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import static com.agoni.security.config.constants.SecurityConstants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


/**
 * @author gyd
 */
@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Resource
    private JwtConfiguration jwtConfiguration;
    
    public static final String LOGIN_SUCCESS = "登录成功";
    @Resource
    private LogininforService logininforService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private TokenCacheManger tokenCacheManger;
    
    private static final Clock CLOCK = DefaultClock.INSTANCE;

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
        String clientId = jwtConfiguration.getMultipleLogin() ? IdWorker.getIdStr() : "0";
        HashMap<String, Object> tokenMap = getTokenMap(username, clientId);
        
        response.setContentType(APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(JSON.toJSONString(ResponseEntity.body(tokenMap)));
        // 登录成功记录
        logininforService.asyncLogininfor(principal.getUsername(), "0", LOGIN_SUCCESS);
    }
    
    /**
     * @param username 用户名
     * @param clientId 新的clientId
     *
     * @return HashMap<String, Object>
     */
    HashMap<String, Object> getTokenMap(String username, String clientId) {
        // accessToken
        String accessToken = jwtTokenUtil.generateToken(username, clientId);
        String accessKey = ACCESS_TOKEN + "::" + username + "::" + clientId;
        tokenCacheManger.putAccessToken(accessKey, accessToken);
        // refreshToken
        String refreshToken = jwtTokenUtil.generateToken(REFRESH_TOKEN + ":" + username, clientId);
        String refreshKey = REFRESH_TOKEN + "::" + username + "::" + clientId;
        tokenCacheManger.putRefreshToken(refreshKey, refreshToken);


        HashMap<String, Object> map = new HashMap<>(8);
        map.put("username",username);
        map.put(ACCESS_TOKEN, accessToken);
        map.put(REFRESH_TOKEN, refreshToken);
        // 过期时间
        Date expires = new Date(CLOCK.now().getTime() + 5 * MINUTE);
        map.put(EXPIRES, D.convert2DateTimeString(expires));
        // 权限
        map.put("roles",Arrays.asList("admin","test"));
        return map;
    }
}
