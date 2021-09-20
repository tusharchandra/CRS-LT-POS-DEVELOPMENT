package com.lt.bean;

public class User {

	
	private String Username;
	private String Password;
	private int RoleId;
	
	public String getUsername() {
		return Username;
	}
	public User(String username, String password, int roleId) {
		super();
		Username = username;
		Password = password;
		RoleId = roleId;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}
	
}
	
