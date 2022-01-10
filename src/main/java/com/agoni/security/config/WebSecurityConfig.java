package com.agoni.security.config;

import com.agoni.dgy.service.UserService;
import com.agoni.security.constants.SecurityConstants;
import com.agoni.security.exception.RestAuthenticationEntryPoint;
import com.agoni.security.filter.JWTUsernamePasswordAuthenticationFilter;
import com.agoni.security.filter.JWTBasicAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author Admin
 */
@Configuration
@EnableWebSecurity //启用web权限
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法验证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
//                .antMatchers(SecurityConstants.SYSTEM_WHITELIST2).hasAnyRole("student") // 学生权限可以查看
//                .antMatchers(SecurityConstants.SYSTEM_WHITELIST3).hasRole("teacher")
                .anyRequest().authenticated();// 其余的所有请求都需要验证

        http.addFilter(new JWTUsernamePasswordAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTBasicAuthenticationFilter(authenticationManager()))
                .exceptionHandling()
                .authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.logout().permitAll();//定义logout不需要验证
    }




}
