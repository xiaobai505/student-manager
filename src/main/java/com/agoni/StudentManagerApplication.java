package com.agoni;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.springframework.security.core.context.SecurityContextHolder.MODE_INHERITABLETHREADLOCAL;

//@EnableCaching//开启缓存
@SpringBootApplication
@MapperScan(basePackages = {"com.agoni.dgy.mapper.**"})
public class StudentManagerApplication {
	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(StudentManagerApplication.class, args);
		//SpringApplicationContextUtil.setApplicationContext(run);
		// 使SecurityContext上下文中的认证信息可以在子线程中获取，解决多线程取不到用户信息的问题
		SecurityContextHolder.setStrategyName(MODE_INHERITABLETHREADLOCAL);
		
	}
}
