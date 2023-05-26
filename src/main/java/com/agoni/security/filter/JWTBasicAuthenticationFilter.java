package com.agoni.security.filter;

import com.agoni.security.config.constants.SecurityConstants;
import com.agoni.security.service.AuthUserService;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.config.enums.ResponseCodeEnum;
import com.agoni.system.response.ResponseEntity;
import com.alibaba.fastjson2.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gyd
 */
@Slf4j
@Component
public class JWTBasicAuthenticationFilter extends OncePerRequestFilter {
    
    @Resource
    AuthUserService authUserService;
    @Resource
    private UserCache userCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1: 请求头没有token ，直接去下一个过滤器
        String header = request.getHeader(SecurityConstants.TOKEN_HEADER);
        
        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 2: 如果获取不到用户名报错  如果过期，报错，返回登录页面
        String userName = getUserName(header,response);
        
        // 3：SecurityContextHolder 没有用户，查询数据库，把权限放到 SecurityContextHolder
        UsernamePasswordAuthenticationToken authentication = getAuthenticationToken(userName);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        chain.doFilter(request, response);
    }

    public UsernamePasswordAuthenticationToken getAuthenticationToken(String userName) {
        // UserCache先从缓存里面找,没有的话,会自动调用loadUserByUsername
        UserDetails userDetails = userCache.getUserFromCache(userName);
        if (userDetails == null) {
            // 根据用户名去查找用户的权限信息
            userDetails = authUserService.loadUserByUsername(userName);
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
    
    /**
     * 解析token，返回用户名
     * @param header 请求头
     * @param response response
     *
     * @return
     */
    private String getUserName(String header, HttpServletResponse response) {
        try {
            return JwtTokenUtil.getUserName(header.replace(SecurityConstants.TOKEN_PREFIX, ""));
        } catch (Exception e) {
            log.error("解析 token 失败了");
            this.exceptionResponse(response, ResponseEntity.body(ResponseCodeEnum.TOKEN_CHECK_FAIL));
        }
        return null;
    }
    
    /**
     * 非法的响应
     *
     * @param response response
     */
    @SneakyThrows
    public void exceptionResponse(HttpServletResponse response, ResponseEntity responseEntity) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(JSON.toJSONString(responseEntity));
    }
}
