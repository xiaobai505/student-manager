package com.agoni.security.config;

import com.agoni.security.constants.SecurityConstants;
import com.agoni.security.filter.JWTBasicAuthenticationFilter;
import com.agoni.security.interceptor.LoginFailureHandler;
import com.agoni.security.interceptor.LoginSuccessHandler;
import com.agoni.security.service.AuthUserService;
import com.agoni.system.response.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author Admin
 */
@Configuration
@EnableWebSecurity //启用web权限
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法验证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginSuccessHandler loginSuccessHandler;
    @Autowired
    LoginFailureHandler loginFailureHandler;
    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    AuthUserService authUserService;
    @Resource
    JWTBasicAuthenticationFilter jwtBasicAuthenticationFilter;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 标准的security认证,根据数据库里面的用户名密码
        auth.userDetailsService(authUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable() // 关闭csrf
                .authorizeRequests()// 配置安全策略
                .antMatchers(SecurityConstants.SYSTEM_WHITELIST).permitAll() // 请求不需要验证
                .anyRequest().authenticated();// 其余的所有请求都需要验证

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // token 以及异常解析
        http.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint);
        http.addFilterBefore(jwtBasicAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        // 登录解析
        http.formLogin().loginProcessingUrl("/auth/login").successHandler(loginSuccessHandler).failureHandler(loginFailureHandler);
        //定义logout不需要验证
        http.logout().permitAll();
    }




}
