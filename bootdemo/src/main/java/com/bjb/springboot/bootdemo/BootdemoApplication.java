package com.bjb.springboot.bootdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@MapperScan("com.bjb.springboot.bootdemo.dao")
public class BootdemoApplication {
	
	private static final Logger logger = LogManager.getLogger(BootdemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BootdemoApplication.class, args);
		
		logger.info("application starts successfully!");
	}
}
