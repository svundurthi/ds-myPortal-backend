package com.ds.myportal.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import com.ds.myportal.dbo.response.UserInfo;
import com.ds.myportal.utils.TokenUtils;

public class XAuthTokenFilter extends GenericFilterBean {

	private transient final String X_AUTH_TOKEN="X-Auth-Token";
	private final UserDetailsService userDetailService;
	
	public  XAuthTokenFilter(UserDetailsService userDetailService) {
		this.userDetailService=userDetailService;
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		String encryptToken=this.extractAuthTokenFromRequest(httpRequest);
		String authToken=null;
		String username=null;
		if(encryptToken!=null){
			
			authToken=encryptToken;
			username=TokenUtils.getUserNameFromToken(authToken);
			if(username!=null){
				UserDetails userDetails=(UserDetails) this.userDetailService.loadUserByUsername(username);
				UserInfo info=(UserInfo)userDetails;
				if(TokenUtils.validateToken(authToken,userDetails)){
					UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(userDetails, null);
					auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
					SecurityContextHolder.getContext().setAuthentication(auth);
					
					
					
				}
			}
			else{
				httpResponse.setStatus(HttpStatus.FORBIDDEN.value());
			}	
			
			
		}
		chain.doFilter(httpRequest, httpResponse);

	}

	private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
		String authToken=httpRequest.getHeader(X_AUTH_TOKEN);
		if(authToken==null){
			authToken=httpRequest.getParameter("token");
			
		}
		return authToken;
	}


}
