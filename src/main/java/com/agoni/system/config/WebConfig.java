package com.agoni.system.config;

import com.agoni.system.Interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 * @author gyd
 */
@Configuration
@ComponentScan(basePackages = {"com.diboot.core"})
public class WebConfig implements WebMvcConfigurer {

    //为了TimeInterceptor 配置拦截器
    @Autowired
    private TimeInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authInterceptor);
    }

}
