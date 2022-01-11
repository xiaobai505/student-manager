package com.agoni.security.config;

import com.agoni.security.Interceptor.LoginFailureHandler;
import com.agoni.security.Interceptor.LoginSuccessHandler;
import com.agoni.security.constants.SecurityConstants;
import com.agoni.security.exception.RestAuthenticationEntryPoint;
import com.agoni.security.filter.JWTBasicAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Admin
 */
@Configuration
@EnableWebSecurity //启用web权限
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法验证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    LoginSuccessHandler loginSuccessHandler;
    LoginFailureHandler loginFailureHandler;
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    public void setLoginFailureHandler(LoginFailureHandler loginFailureHandler) {
        this.loginFailureHandler = loginFailureHandler;
    }

    @Autowired
    public void setLoginSuccessHandler(LoginSuccessHandler loginSuccessHandler) {
        this.loginSuccessHandler = loginSuccessHandler;
    }

    @Autowired
    public void setRestAuthenticationEntryPoint(RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("123123"))
                .roles("teacher","student");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable() // 关闭csrf
                .authorizeRequests()// 配置安全策略
                .antMatchers(SecurityConstants.SYSTEM_WHITELIST).permitAll() // 请求不需要验证
                .anyRequest().authenticated();// 其余的所有请求都需要验证

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.formLogin().loginProcessingUrl("/auth/login").successHandler(loginSuccessHandler).failureHandler(loginFailureHandler);

        http.addFilter(new JWTBasicAuthenticationFilter(authenticationManager()));
            //.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint);

        //定义logout不需要验证
        http.logout().permitAll();
    }




}
