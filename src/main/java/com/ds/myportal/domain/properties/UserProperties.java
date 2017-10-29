package com.ds.myportal.domain.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/user_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="user")
public class UserProperties {

	public UserProperties() {
		super();
	}

	private String getUser;
	private String updateUser;
	
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getGetUser() {
		return getUser;
	}

	public void setGetUser(String getUser) {
		this.getUser = getUser;
	}

}
