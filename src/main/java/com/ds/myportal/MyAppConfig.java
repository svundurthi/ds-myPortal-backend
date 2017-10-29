package com.ds.myportal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.ds.myportal.dao.UserDao;
import com.ds.myportal.daoImpl.UserDaoImpl;
import com.ds.myportal.service.LoginControllerService;

@ComponentScan
@EnableAutoConfiguration

public abstract class MyAppConfig {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	public LoginControllerService loginControllerService;

	
	@Bean
	public UserDao userDao(){
		return new UserDaoImpl();
	}


	
}
