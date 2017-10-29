package com.ds.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.ds.myportal.dbo.request.AuthenticationReqest;
import com.ds.myportal.dbo.response.UserInfo;
import com.ds.myportal.domain.AuthenticationToken;
import com.ds.myportal.utils.SecurityUtils;
import com.ds.myportal.utils.TokenUtils;


@Service("loginControllerService")
public class LoginControllerService {
	
	@Autowired
	@Qualifier("userDetailsService")
	private transient UserDetailsService userDetailsService;
	
	@Autowired
	private transient AuthenticationProvider authenticationProvider;
	
	@Autowired
	private transient SecurityUtils securtiyUtils;
	public AuthenticationToken login(AuthenticationReqest authenticationReqest){
		
		
		UserInfo userinfo=new UserInfo();
		Authentication auth=null;
		final UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(
				authenticationReqest.getUsername(),authenticationReqest.getPassword());
		
		userinfo=(UserInfo) userDetailsService.loadUserByUsername(authenticationReqest.getUsername());
		
		auth=authenticationProvider.authenticate(token);
		//securtiyUtils.login(userinfo);
		System.out.println("yes");
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		return new AuthenticationToken(TokenUtils.createToken(userinfo));
		
	}

	


}
