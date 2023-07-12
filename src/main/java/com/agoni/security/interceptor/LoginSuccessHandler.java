package com.agoni.security.interceptor;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.agoni.core.cache.TokenCacheManger;
import com.agoni.security.config.constants.JwtConfiguration;
import com.agoni.security.model.TokenVo;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.service.LogininforService;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.impl.DefaultClock;
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

import static com.agoni.security.config.constants.SecurityConstants.ACCESS_TOKEN;
import static com.agoni.security.config.constants.SecurityConstants.REFRESH_TOKEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


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
        TokenVo tokenVo = getTokenMap(username, clientId);

        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write(JSON.toJSONString(ResponseEntity.body(tokenVo)));
        // 登录成功记录
        logininforService.asyncLogininfor(principal.getUsername(), "0", LOGIN_SUCCESS);
    }
    
    /**
     * @param username 用户名
     * @param clientId 新的clientId
     *
     * @return HashMap<String, Object>
     */
    private TokenVo getTokenMap(String username, String clientId) {
        // accessToken 和 refreshToken
        String accessToken = jwtTokenUtil.generateToken(username, clientId);
        DateTime expirationDate = DateUtil.offsetMillisecond(DateUtil.date(), jwtConfiguration.getRefreshExpireTime());
        String refreshToken = jwtTokenUtil.generateToken(REFRESH_TOKEN + ":" + username, clientId, expirationDate);
        // 保存到redis
        String accessKey = ACCESS_TOKEN + "::" + username + "::" + clientId;
        String refreshKey = REFRESH_TOKEN + "::" + username + "::" + clientId;
        tokenCacheManger.putAccessToken(accessKey, accessToken);
        tokenCacheManger.putRefreshToken(refreshKey, refreshToken);

        // 当前时间偏移 jwtConfiguration.getAccessExpireTime() 后为过期时间
        DateTime expires = DateUtil.offsetMillisecond(DateUtil.date(), jwtConfiguration.getAccessExpireTime());
        TokenVo build = TokenVo
                .builder()
                .username(username)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expires(expires)
                .build();
        return build;
    }
}
