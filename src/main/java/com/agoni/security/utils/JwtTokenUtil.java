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

    public static String getUserName(String token) {
        return getTokenBody(token).getSubject();
    }

    /**
     * Token是否过期
     */
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    public static Claims getTokenBody(String token) {
        return Jwts.parser()
                .setSigningKey(SecurityConstants.SecurityKey)
                .parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                .getBody();
    }

    public static String generateToken(String username) {
        Map<String, Object> role = new HashMap<>(16);
        role.put("username", username);
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);
        String tokenPrefix = Jwts.builder()
                .setClaims(role)
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SecurityKey)
                .compact();
        return SecurityConstants.TOKEN_PREFIX + tokenPrefix;
    }

    private static Date calculateExpirationDate(Date createdDate) {
        // 过期时间 分钟
        return new Date(createdDate.getTime() + 1000 * 60 * SecurityConstants.Minute);
    }

    public static void main(String[] args) {
        String token = generateToken("admin");
        log.info("token: " + token);
        String userName = getUserName(token.replace(SecurityConstants.TOKEN_PREFIX, ""));
        log.info("userName: " + userName);
    }
}
