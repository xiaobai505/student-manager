package com.agoni.security.filter;

import com.agoni.security.config.constants.JwtConfiguration;
import com.agoni.security.config.constants.SecurityConstants;
import com.agoni.security.service.AuthUserService;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.config.enums.ResponseCodeEnum;
import com.agoni.system.response.ResponseEntity;
import com.alibaba.fastjson2.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
    @Resource
    private JwtConfiguration jwtConfiguration;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1: 请求头没有token ，直接去下一个过滤器
        String header = request.getHeader(jwtConfiguration.getHeader());

        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 2: 如果获取不到用户名报错  如果过期，报错，返回登录页面
        String userName = getUserName(header,response);
        // 如果用户为空 代表解析失败
        if (StringUtils.isBlank(userName)) {
            log.error("token解析失败");
            chain.doFilter(request, response);
            return;
        }
        // 4.如果没有过期 且当前上下文中没有用户信息 通过token 获取到user信息 放入到 securitycontext 进入下一个过滤器。
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            log.warn(" SecurityContextHolder 没有 ！！！");
        }
        setAuthentication(userName,request);

        chain.doFilter(request, response);
    }

    private void setAuthentication(String userName, HttpServletRequest request) {
        // UserCache先从缓存里面找,没有的话,会自动调用loadUserByUsername
        UserDetails userDetails = userCache.getUserFromCache(userName);
        if (userDetails == null) {
            // 根据用户名去查找用户的权限信息 ，保存缓冲
            userDetails = authUserService.loadUserByUsername(userName);
        }
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * 解析token，返回用户名
     * @param header 请求头
     * @param response response
     *
     * @return string
     */
    private String getUserName(String header, HttpServletResponse response) {
        try {
            return JwtTokenUtil.getUserName(header.replace(SecurityConstants.TOKEN_PREFIX, ""));
        } catch (Exception e) {
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
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(JSON.toJSONString(responseEntity));
    }
}
