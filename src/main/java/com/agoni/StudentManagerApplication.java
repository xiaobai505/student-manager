package com.agoni;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.springframework.security.core.context.SecurityContextHolder.MODE_INHERITABLETHREADLOCAL;


//@EnableCaching//开启缓存
@EnableAsync
@SpringBootApplication
@MapperScan(basePackages = {"com.agoni.dgy.mapper.**"})
public class StudentManagerApplication {
	public static void main(String[] args) {
		System.setProperty("spring.security.strategy", SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
		SpringApplication.run(StudentManagerApplication.class, args);
	}
}
