package com.ds.myportal.dbo.request;

public class AuthenticationReqest {

	public String username;
	public String password;
	
	
	
	public AuthenticationReqest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public AuthenticationReqest() {
	
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
}
