package com.agoni.security.filter;

import com.agoni.security.constants.SecurityConstants;
import com.agoni.security.exception.ErrorResponse;
import com.agoni.security.exception.ExceptionType;
import com.agoni.security.service.AuthUserService;
import com.agoni.security.utils.JwtTokenUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
        // TODO 下面的一直是 null 不知道 怎么搞
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            log.info(" SecurityContextHolder 没有数据，查询数据库！");
            UsernamePasswordAuthenticationToken authentication = getUsernamePasswordAuthenticationToken(request, userName);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(HttpServletRequest request, String userName) {
        // 根据用户名去查找用户的权限
        UserDetails userDetails = authUserService.loadUserByUsername(userName);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    private String getUserName(String header,HttpServletResponse response) {
        String userName = null;
        try {
            userName = JwtTokenUtil.getUserName(header.replace(SecurityConstants.TOKEN_PREFIX, ""));
        } catch (Exception e) {
            log.info("解析 token 失败了");
            ErrorResponse errorResponse = ErrorResponse.builder().code(ExceptionType.TOKEN_CHECK_FAIL.getCode())
                    .message(ExceptionType.TOKEN_CHECK_FAIL.getMessage()).build();
            this.exceptionResponse(HttpStatus.UNAUTHORIZED.value(),response,errorResponse);
        }
        return userName;
    }

    /**
     * 非法的响应
     * @param response response
     */
    @SneakyThrows
    public void exceptionResponse(int status, HttpServletResponse response, ErrorResponse errorResponse) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(status);
        response.getWriter().write(JSONObject.toJSONString(errorResponse));
    }
}
