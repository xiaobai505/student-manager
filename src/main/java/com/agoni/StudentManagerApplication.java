package com.agoni;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableCaching//开启缓存
@SpringBootApplication
@MapperScan(basePackages = {"com.agoni.dgy.mapper.**"})
public class StudentManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentManagerApplication.class, args);
	}
}
