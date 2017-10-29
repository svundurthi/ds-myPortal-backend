package com.ds.myportal.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ds.myportal.dao.UserDao;
import com.ds.myportal.dbo.response.UserInfo;

@Component("securtiyUtils")
public class SecurityUtils {
	
	@Autowired
	UserDao userDao;

	public void login(final UserInfo userinfo) {
		
		
		
		userinfo.setLoggedDate(new Date());
		userinfo.setInvalidAttempts(0);
		userinfo.setLastLoggedBy(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		userDao.updateUserDetails(userinfo);
		
	}


	      
	
}
