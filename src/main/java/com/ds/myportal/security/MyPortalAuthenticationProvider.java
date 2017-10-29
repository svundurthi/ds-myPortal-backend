package com.ds.myportal.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ds.myportal.dbo.request.AuthenticationReqest;
import com.ds.myportal.domain.AuthenticationToken;
import com.ds.myportal.service.CustomUserDetailService;
import com.ds.myportal.service.LoginControllerService;

@Component("authenticationProvider")
public class MyPortalAuthenticationProvider extends DaoAuthenticationProvider{
	final static Logger logger=LoggerFactory.getLogger(MyPortalAuthenticationProvider.class);
	
	
	@Autowired
	@Qualifier("userDetailsService")
	public void setUserDetailService(final CustomUserDetailService setUserDetailsService){
		super.setUserDetailsService(setUserDetailsService);
	}
	
	@Autowired
	private transient LoginControllerService loginControllerService;
	
	public AuthenticationToken login(final AuthenticationReqest authenticationReqest){
		AuthenticationToken token=null;
		
		token=loginControllerService.login(authenticationReqest);
		
		return token;
				
	}
	
	@Override
	public Authentication authenticate(final Authentication authentication){
		return super.authenticate(authentication);
	}


	
}
