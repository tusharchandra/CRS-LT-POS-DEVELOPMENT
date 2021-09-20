package com.lt.bean;

/**
 * 
 * @author G4-FullStackGroup
 * Admin Class
 * 
 */
public class Admin 
{

	
	private String AdminName;
	private String password;
	
	/**
	 *Parametrised Constructor
	 * @return values
	 */
	public Admin(String adminName, String password) {
		super();
		AdminName = adminName;
		this.password = password;
	}
	
	/**
	 * Method to get adminName
	 * @param getAdminName
	 */
	public String getAdminName() {
		return AdminName;
	}
	
	/**
	 * Method to set adminName
	 * @param setAdminName
	 */
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	
	/**
	 * Method to get adminPassword
	 * @param getAdminPassword
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Method to set adminPassword
	 * @param getAdminPassword
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

}
