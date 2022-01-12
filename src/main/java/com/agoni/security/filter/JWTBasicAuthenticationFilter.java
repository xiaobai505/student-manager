package com.agoni.security.filter;

import com.agoni.security.constants.SecurityConstants;
import com.agoni.security.service.AuthUserService;
import com.agoni.security.utils.JwtTokenUtil;
import com.alibaba.druid.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gyd
 */
@Slf4j
public class JWTBasicAuthenticationFilter extends BasicAuthenticationFilter {

    public JWTBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1: 请求头没有token ，直接去下一个过滤器
        String header = request.getHeader(SecurityConstants.TOKEN_HEADER);
        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 2: 如果获取不到用户名报错
        String userName = getString(header);

        // 3：如果过期，报错，返回登录页面

        // 4：SecurityContextHolder 没有用户，查询数据库，把权限放到 SecurityContextHolder
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            log.info(" SecurityContextHolder 没有数据，查询数据库！");
            UsernamePasswordAuthenticationToken authentication = getUsernamePasswordAuthenticationToken(request, userName);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(HttpServletRequest request, String userName) {
        //获取容器
        ServletContext context = request.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        AuthUserService bean = ctx.getBean(AuthUserService.class);
        // 根据用户名去查找用户的权限
        UserDetails userDetails = bean.loadUserByUsername(userName);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    private String getString(String header) {
        String userName = JwtTokenUtil.getUserName(header.replace(SecurityConstants.TOKEN_PREFIX, ""));
        if (StringUtils.isEmpty(userName)){
            return null;
        }
        return userName;
    }
}
