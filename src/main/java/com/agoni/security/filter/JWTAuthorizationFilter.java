package com.agoni.security.filter;

import com.agoni.security.utils.JwtTokenUtil;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import sun.security.util.SecurityConstants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gyd
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("token");
        // 如果请求头中没有Authorization信息则直接放行了
        // if (authorization == null || !authorization.startsWith("token")) {
        if (token == null) {
            chain.doFilter(request, response);
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置授权信息
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(token));
        super.doFilterInternal(request, response, chain);
    }


    /**
     * 这里从token中获取用户信息并新建一个token
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String authorization) {
//        String token = authorization.replace(SecurityConstants.TOKEN_PREFIX, "");
//
//        try {
//            String username = JwtTokenUtils.getUsernameByToken(token);
//            // 通过 token 获取用户具有的角色
//            List<SimpleGrantedAuthority> userRolesByToken = JwtTokenUtils.getUserRolesByToken(token);
//            if (!StringUtils.isEmpty(username)) {
//                return new UsernamePasswordAuthenticationToken(username, null, userRolesByToken);
//            }
//        } catch (SignatureException | ExpiredJwtException exception) {
//            logger.warning("Request to parse JWT with invalid signature . Detail : " + exception.getMessage());
//        }
        return null;
    }
}
