package com.ds.myportal.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/myportal/admin")
public class LogoutController {
	final static Logger logger=LoggerFactory.getLogger(LogoutController.class);
	
	
	@RequestMapping(value="/logout",method={RequestMethod.POST})
	public void login (){
	
		logger.info("inside LogoutController");
		SecurityContextHolder.getContext().setAuthentication(null);
		
	}
	
	
}
