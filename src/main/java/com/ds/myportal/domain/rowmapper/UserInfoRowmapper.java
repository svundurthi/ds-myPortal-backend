package com.ds.myportal.domain.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ds.myportal.dbo.response.UserInfo;

public class UserInfoRowmapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo user=new UserInfo();
		user.setUserKey(rs.getString("userKey"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setUsername(rs.getString("username"));
		
		
		user.setAccountNotExpired(rs.getBoolean("isAccountNotExpired"));
		user.setAccountNotLocked(rs.getBoolean("isAccountNotLocked"));
		user.setInvalidAttempts(rs.getInt("invalidAttempts"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		user.setLastLoggedBy(rs.getString("lastLoggedBy"));
		user.setLoggedDate(rs.getDate("loggedDate"));
		
		return user;
	}
	

}
