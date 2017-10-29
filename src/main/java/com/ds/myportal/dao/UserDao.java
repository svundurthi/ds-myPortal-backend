package com.ds.myportal.dao;

import com.ds.myportal.dbo.response.UserInfo;

public interface UserDao {

	public UserInfo loadUserByUsername(String username);

	public void updateUserDetails(UserInfo userinfo);
}
