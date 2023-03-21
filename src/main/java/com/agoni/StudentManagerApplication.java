package com.agoni;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.springframework.security.core.context.SecurityContextHolder.MODE_INHERITABLETHREADLOCAL;


@EnableAsync
@SpringBootApplication
@MapperScan(basePackages = {"com.agoni.dgy.mapper.**"})
public class StudentManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentManagerApplication.class, args);
	}
}
