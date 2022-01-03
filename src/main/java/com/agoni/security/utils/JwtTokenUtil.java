package com.agoni.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
     * 秘钥
     */
    @Value("${jwt.secret}")
    private String secret;

    /**
     * 超时时间
     */
    @Value("${jwt.expiration}")
    private Long expiration;

    public static void main(String[] args) {
//        Map<String, Object> claims = new HashMap<>(16);
//        claims.put("username", "admin");
//        final Date createdDate = clock.now();
//
//        final Date expirationDate =  new Date((createdDate.getTime()+(1000*5)));
//        String token = Jwts.builder().setClaims(claims).setSubject("admin").setIssuedAt(createdDate).setExpiration(expirationDate)
//                //                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//        log.info("token"+token);
        String token= "eyJhbGciOiJub25lIn0.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY0MTIzMTg5OCwiaWF0IjoxNjQxMjMxNzc4LCJ1c2VybmFtZSI6ImFkbWluIn0.";
        Jwt parse = Jwts.parser().parse(token);
        log.info("parse"+parse);


    }

    public static Jwt checkToken(String token) {
        log.info("check token:" + token);
        Jwt jwt = Jwts.parser().parse(token);
        return jwt;
    }

    public Claims getAllClaimsFromToken(String token) {
        // return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Jwts.parser().parseClaimsJws(token).getBody();
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>(16);
        claims.put("username", username);
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    private Date calculateExpirationDate(Date createdDate) {
        // 604800   分钟
        return new Date(createdDate.getTime() + expiration * 1000 * 60 );
    }


}
