package com.agoni.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Admin
 */
@Configuration
@EnableWebSecurity //启用web权限
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法验证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("asd").password("123").roles("all");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] antMatchers={"/dgy/**","/*","/login/**","/**"};
        http.authorizeRequests()//配置安全策略
                .antMatchers(antMatchers).permitAll()//定义/请求不需要验证  "/","/hello"
                .anyRequest().authenticated()//其余的所有请求都需要验证
                .and()
//                .logout()
//                .permitAll()//定义logout不需要验证
//                .and()
                .formLogin();//使用form表单登录

//        http.exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint())
//                .and()
//                .addFilter(casAuthenticationFilter())
//                .addFilterBefore(casLogoutFilter(), LogoutFilter.class)
//                .addFilterBefore(singleSignOutFilter(), CasAuthenticationFilter.class);

        //关闭csrf
        http.csrf().disable();
//                .addFilter(new JwtLoginFilter(super.authenticationManager(),rsaKeyProperties))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);    //禁用session
    }

}
