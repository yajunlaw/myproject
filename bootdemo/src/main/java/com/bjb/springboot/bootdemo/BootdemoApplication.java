package com.bjb.springboot.bootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.bjb.springboot.bootdemo.dao")
public class BootdemoApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BootdemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BootdemoApplication.class, args);
		
		logger.info("application starts successfully!");
	}
}
