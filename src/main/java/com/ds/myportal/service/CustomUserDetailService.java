package com.ds.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ds.myportal.dao.UserDao;





@Component("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return (UserDetails) userDao.loadUserByUsername(username);
	}
}
