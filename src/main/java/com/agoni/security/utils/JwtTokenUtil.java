package com.agoni.security.utils;

import com.agoni.security.constants.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
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

    private static final Clock clock = DefaultClock.INSTANCE;
    
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
     * @param token
     *
     * @return
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
     * @param username 用户名
     * @param clientId 客户端编号
     *
     * @return
     */
    public String generateToken(String username, String clientId) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);
        Map<String, Object> claims = new HashMap<>(16);
        claims.put("clientId", clientId);
        String tokenPrefix = Jwts.builder()
                                 .setClaims(claims)
                                 .setSubject(username)
                                 .setIssuedAt(createdDate)
                                 .setExpiration(expirationDate)
                                 .signWith(SignatureAlgorithm.HS512, SecurityConstants.SecurityKey)
                                 .compact();
        return tokenPrefix;
    }
    
    /**
     * 获取 token 实体
     * @param token
     *
     * @return
     */
    private static Claims getTokenBody(String token) {
        return Jwts.parser()
                   .setSigningKey(SecurityConstants.SecurityKey)
                   .parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                   .getBody();
    }
    
    private static Date calculateExpirationDate(Date createdDate) {
        // 过期时间 分钟
        return new Date(createdDate.getTime() + 1000 * 60 * SecurityConstants.Minute);
    }
}
