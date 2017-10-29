package com.ds.myportal.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ds.myportal.dbo.request.AuthenticationReqest;
import com.ds.myportal.dbo.response.UserInfo;
import com.ds.myportal.domain.AuthenticationToken;
import com.ds.myportal.security.MyPortalAuthenticationProvider;
import com.ds.myportal.service.LoginControllerService;

@RestController
@RequestMapping("/api/myportal/admin")
public class LoginController {
	final static Logger logger=LoggerFactory.getLogger(LoginController.class);
	
	
	
	@Autowired
	private transient  final MyPortalAuthenticationProvider authenticationProvider;
	
	@Autowired
	public LoginController(final MyPortalAuthenticationProvider authenticationProvider){
		this.authenticationProvider=authenticationProvider;
		
	}
	
	@RequestMapping(value="/login",method={RequestMethod.POST},
	consumes="application/json", produces="application/json")
	public @ResponseBody AuthenticationToken login (@RequestBody AuthenticationReqest  authenticationReqest){
	
		logger.info("inside logincontroller");
		return this.authenticationProvider.login(authenticationReqest);
		
	}
	
	
	
	
	
	
}
