package com.agoni.system.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * Description: 设置链路追踪的值，初期单体项目先简单用
 * Date: 2023-04-05
 * @author gyd
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
@Component
public class HttpTraceIdFilter implements Filter {

    private final static String TID = "tid";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String tid = UUID.randomUUID().toString();
        MDC.put(TID, tid);
        chain.doFilter(request, response);
        MDC.remove(TID);
    }

}
