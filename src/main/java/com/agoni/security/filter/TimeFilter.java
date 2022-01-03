package com.agoni.security.filter;


import com.agoni.security.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author gyd
 */
//@Component
@Slf4j
public class TimeFilter implements Filter {

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
        log.info("time filter start");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("time filter 耗时:"+ (System.currentTimeMillis() - start));
        log.info("time filter finish");
    }

    @Override
    public void destroy() {
        log.info("time filter init");
    }
}
