package com.agoni.security.utils;

import com.agoni.security.config.constants.JwtConfiguration;
import com.agoni.security.config.constants.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.agoni.security.config.constants.SecurityConstants.MINUTE;

/**
 * @author gyd
 */
@Component
@Slf4j
public class JwtTokenUtil implements Serializable {

    @Value("${jwt.securityKey}")
    private static String securityKey;
    private static final Clock CLOCK = DefaultClock.INSTANCE;

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
        return (String) claims.get("clientId");
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
        return getTokenExpirationDate(token).before(new Date());
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
        final Date expirationDate = calculateExpirationDate(CLOCK.now());
        Map<String, Object> claims = new HashMap<>(16);
        claims.put("clientId", clientId);
        String tokenPrefix = Jwts.builder()
                                 .setClaims(claims)
                                 .setSubject(username)
                                 .setIssuedAt(CLOCK.now())
                                 .setExpiration(expirationDate)
                                 .signWith(SignatureAlgorithm.HS512, securityKey)
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
                   .setSigningKey(securityKey)
                   .parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                   .getBody();
    }

    private Date calculateExpirationDate(Date createdDate) {
        // return new Date(createdDate.getTime() + jwtConfiguration.getExpiration() * 1000);
        return new Date(createdDate.getTime() + 1 * MINUTE);
    }
}
