package com.ds.myportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ds.myportal.controller.LoginController;

import ch.qos.logback.classic.LoggerContext;

@SpringBootApplication
public class Application extends MyAppConfig{
	final static Logger logger=LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		logger.info("Starting Application");
		SpringApplication.run(Application.class, args);
		
		
		
	        
	}
}
