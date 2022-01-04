package com.agoni.security.filter;


import com.agoni.security.utils.JwtTokenUtil;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author gyd
 */
@Component
@Slf4j
public class AuthFilter implements Filter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        log.info("time filter destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 如果是登录  直接过
        String requestURI = request.getRequestURI();
        if (!StringUtils.equals("/auth/login",requestURI)){
            // 其他的请求校验token
            String token = request.getHeader("token");
            try {
                Jwt jwt = jwtTokenUtil.checkToken(token);
            }catch (Exception e){
                e.printStackTrace();
                HttpServletResponse response= (HttpServletResponse) servletResponse;
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                response.setStatus(201);
                response.getWriter().write("权限不足");
                return;
            }

        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("time filter init");
    }
}
