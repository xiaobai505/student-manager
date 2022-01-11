package com.agoni.security.config;

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

/**
 * @author Admin
 */
@Configuration
@EnableWebSecurity //启用web权限
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法验证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    public void setLoginSuccessHandler(LoginSuccessHandler loginSuccessHandler) {
        this.loginSuccessHandler = loginSuccessHandler;
    }

    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    public void setRestAuthenticationEntryPoint(RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
        this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("root").password("123").roles("student");
        auth.inMemoryAuthentication().withUser("admin").password("123").roles("teacher");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable() // 关闭csrf
                .authorizeRequests()// 配置安全策略
                .antMatchers(SecurityConstants.SYSTEM_WHITELIST).permitAll() // 请求不需要验证
                .anyRequest().authenticated();// 其余的所有请求都需要验证

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // todo 后面在看，不知道 这么写。
        // http.formLogin().loginProcessingUrl("/auth/login").successHandler(loginSuccessHandler);

        http.addFilter(new JWTBasicAuthenticationFilter(authenticationManager()))
            .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint);

        //定义logout不需要验证
        http.logout().permitAll();
    }




}
