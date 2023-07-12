package com.agoni;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
@MapperScan(basePackages = {"com.agoni.*.mapper.**"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}