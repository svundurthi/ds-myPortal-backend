package com.ds.myportal.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Hex;

import com.ds.myportal.security.MyPortalAuthenticationProvider;
import com.mysql.jdbc.StringUtils;

public class TokenUtils {
	final static Logger logger=LoggerFactory.getLogger(TokenUtils.class);
	
	
	public static final String SECRET_KEY="thisisasecrettokentobechanged";
	

	public static String getUserNameFromToken(String authToken) {
		if(StringUtils.isEmptyOrWhitespaceOnly(authToken)){
			return null;
		}
		String[] parts=authToken.split(":");
		return parts[0];
	}

	public static boolean validateToken(final String authToken,final  UserDetails userDetails) {
		String[] parts=authToken.split(":");
		long expires=Long.parseLong(parts[1]);
		String signature=parts[2];
		if(expires<System.currentTimeMillis()){
			return false;
		}
			
		return signature.equals(TokenUtils.computeSignature(userDetails, expires));
	}

	public static String createToken(UserDetails userinfo) {
	
		long expires=System.currentTimeMillis()+1000L*60*60;
		StringBuilder tokenBuilder=new StringBuilder();
		tokenBuilder.append(userinfo.getUsername());
		tokenBuilder.append(":");
		tokenBuilder.append(expires);
		tokenBuilder.append(":");
		tokenBuilder.append(TokenUtils.computeSignature(userinfo,expires));
		
		logger.info("Token {}"+tokenBuilder.toString());
		return tokenBuilder.toString();
	}

	private static String computeSignature(final UserDetails userDetails, final long expires) {
		StringBuilder signatureBuilder=new StringBuilder();
		signatureBuilder.append(userDetails.getUsername());
		signatureBuilder.append(":");
		signatureBuilder.append(expires);
		signatureBuilder.append(":");
		signatureBuilder.append(userDetails.getPassword());
		signatureBuilder.append(":");
		signatureBuilder.append(TokenUtils.SECRET_KEY);
		MessageDigest digest=null;
		try {
			digest=MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
	
		
		return new String(Hex.encode(digest.digest(signatureBuilder.toString().getBytes())));
	}

}
