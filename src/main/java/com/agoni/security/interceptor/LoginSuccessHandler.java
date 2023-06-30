package com.agoni.security.interceptor;

import com.agoni.security.config.constants.SecurityConstants;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.service.LogininforService;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


/**
 * @author gyd
 */
@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    
    /**
     * 是否允许一个账号多个设备登录
     */
    @Value("${JWT.multipleLogin}")
    private boolean multipleLogin;
    
    /**
     * 登录失效时间（多长时间不操作重新登录）
     */
    @Value("${JWT.expireTime}")
    private Integer expireTime;
    
    /**
     * 刷新失效时间（多长时间不操作重新登录）
     */
    @Value("${JWT.refreshExpireTime}")
    private Integer refreshExpireTime;
    
    public static final String LOGIN_SUCCESS = "登录成功";
    @Resource
    private LogininforService logininforService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    
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
        HashMap<String, Object> tokenMap = getTokenMap(username, multipleLogin ? IdWorker.getIdStr() : "0");
        
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("application/json;charset=utf-8");
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
    HashMap<String, Object> getTokenMap(String username,String clientId){
        HashMap<String, Object> map = new HashMap<>(8);
        // username
        map.put("username",username);
        // accessToken
        String accessToken = jwtTokenUtil.generateToken(username,clientId);
        stringRedisTemplate.opsForValue().set(SecurityConstants.ACCESS_TOKEN + "::" + username + "::" + clientId,
                accessToken, expireTime, TimeUnit.SECONDS);
        map.put(SecurityConstants.ACCESS_TOKEN, accessToken);
        
        // refreshToken
        String refreshToken = jwtTokenUtil.generateToken(SecurityConstants.REFRESH_TOKEN + ":" + username, clientId);
        stringRedisTemplate.opsForValue().set(SecurityConstants.REFRESH_TOKEN + "::" + username + "::" + clientId,
                refreshToken, refreshExpireTime, TimeUnit.SECONDS);
        map.put(SecurityConstants.REFRESH_TOKEN, refreshToken);
    
        // 过期时间
        final Date createdDate = CLOCK.now();
        Date expires = new Date(createdDate.getTime() + expireTime * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");
        map.put(SecurityConstants.EXPIRES, sdf.format(expires));
        
        // 权限
        map.put("roles",Arrays.asList("admin","test"));
        return map;
    }
}
