package com.li.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// constants
	public static String USER = "USER";  //两种用户
	public static String ADMIN = "ADMIN";
	
	private Long id;
	private String username;
	private String password;
	private String roles;
	
	public User() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String userName) {
		this.username = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	


	public static void setUSER(String USER) {
		User.USER = USER;
	}

	public static void setADMIN(String ADMIN) {
		User.ADMIN = ADMIN;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;

	}

	public static String getUSER() {
		return USER;
	}

	public static String getADMIN() {
		return ADMIN;
	}
	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}  //赋予该用户的角色
	
	public Set<String> getRolesSet() {
		if (null == roles) {
			return null;
		}
		return Collections.unmodifiableSet(
		        new HashSet<String>(Arrays.asList(getRoles().split(","))));
	}
	
	public void addRole(String role) {
		String currRoles = this.getRoles();
		if (null == currRoles || this.getRoles().contains(role)) {
			return;
		}
		this.setRoles(currRoles + "," + role);
	}

}