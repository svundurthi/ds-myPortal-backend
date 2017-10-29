package com.ds.myportal.dbo.response;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfo implements UserDetails {

	
	private String userKey;
	private String username;
	private String password;
	private String role;
	private String email;
	private String phone;
	private Date loggedDate;
	private int invalidAttempts;
	private String lastLoggedBy;
	private boolean isAccountNotExpired;
	private boolean isAccountNotLocked;
	

	public boolean isAccountNotExpired() {
		return isAccountNotExpired;
	}
	public void setAccountNotExpired(boolean isAccountNotExpired) {
		this.isAccountNotExpired = isAccountNotExpired;
	}
	public boolean isAccountNotLocked() {
		return isAccountNotLocked;
	}
	public void setAccountNotLocked(boolean isAccountNotLocked) {
		this.isAccountNotLocked = isAccountNotLocked;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastLoggedBy() {
		return lastLoggedBy;
	}
	public void setLastLoggedBy(String lastLoggedBy) {
		this.lastLoggedBy = lastLoggedBy;
	}

	public Date getLoggedDate() {
		return loggedDate;
	}
	public void setLoggedDate(Date loggedDate) {
		this.loggedDate = loggedDate;
	}
	public int getInvalidAttempts() {
		return invalidAttempts;
	}
	public void setInvalidAttempts(int invalidAttempts) {
		this.invalidAttempts = invalidAttempts;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserInfo [userKey=" + userKey + ", username=" + username + ", role=" + role + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
	
		return isAccountNotExpired();
	}
	@Override
	public boolean isAccountNonLocked() {
		
		return isAccountNotLocked;
	}
	@Override
	public boolean isCredentialsNonExpired() {		
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
