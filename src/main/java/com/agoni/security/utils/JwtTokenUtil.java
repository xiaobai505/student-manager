package com.agoni.security.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.agoni.security.config.constants.JwtConfiguration;
import com.agoni.security.config.constants.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gyd
 */
@Component
@Slf4j
public class JwtTokenUtil implements Serializable {

    private static final String SECURITY_KEY = "dongyyds";
    private static final String CLIENT_ID = "clientId";
    private static final String USER_NAME = "userName";
    private static final String REFRESH_TOKEN = "refreshToken:";
    private final JwtConfiguration jwtConfiguration;

    public JwtTokenUtil(JwtConfiguration configuration) {
        this.jwtConfiguration = configuration;
    }

    /**
     * 获取用户名
     * @param token token值
     *
     * @return 用户名
     */
    public static String getUserName(String token) {
        return getTokenBody(token).getSubject();
    }
    
    /**
     * 获取 ClientId
     * @param token token值
     *
     * @return ClientId
     */
    public static String getClientId(String token) {
        final Claims claims = getTokenBody(token);
        return (String) claims.get(CLIENT_ID);
    }

    /**
     * 查看token过期时间
     *
     * @param token token值
     * @return java.util.Date
     * @author t-guoyu.dong@pcitc.com
     * @date 2023-05-26
     */
    public static Date getTokenExpirationDate(String token) {
        return getTokenBody(token).getExpiration();
    }

    /**
     * Token是否过期
     */
    public static boolean isExpiration(String token) {
        return getTokenExpirationDate(token).before(DateUtil.date());
    }
    
    /**
     * 创建Token
     *
     * @param username 用户名
     * @param clientId 客户端编号
     * @return java.lang.String
     * @author t-guoyu.dong@pcitc.com
     * @date 2023-05-26
     */
    public String generateToken(String username, String clientId) {
        final Date expirationDate = calculateExpirationDate(DateUtil.date());
        return generateToken(username, clientId, expirationDate);
    }

    /**
     * 创建Token
     *
     * @param username 用户名
     * @param clientId 客户端编号
     * @param expirationDate 过期时间
     * @return java.lang.String
     * @author t-guoyu.dong@pcitc.com
     * @date 2023-05-26
     */
    public String generateToken(String userName, String clientId, Date expirationDate) {
        Map<String, Object> claims = new HashMap<>(16);
        claims.put(CLIENT_ID, clientId);
        userName = userName.replace(REFRESH_TOKEN, "");
        claims.put(USER_NAME, userName);
        String tokenPrefix = Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(DateUtil.date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
                .compact();
        return tokenPrefix;
    }
    
    /**
     * 获取 token 实体
     *
     * @param token token值
     * @return io.jsonwebtoken.Claims
     * @author t-guoyu.dong@pcitc.com
     * @date 2023-05-26
     */
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                   .setSigningKey(SECURITY_KEY)
                   .parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                   .getBody();
    }

    private DateTime calculateExpirationDate(DateTime createdDate) {
        // DateUtil
        return DateUtil.offsetMillisecond(createdDate, jwtConfiguration.getAccessExpireTime());
    }
}
