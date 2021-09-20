package com.lt.business;

import com.lt.dao.UserDAOImpl;

public class UserImplService implements UserInterface
{

	UserDAOImpl userDAOImpl= new UserDAOImpl();

	@Override
	public boolean login(String username, String password) throws Exception
	{
		return userDAOImpl.verifyCredential(username, password);
	}

	@Override
	public String viewRole() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getRole(String userId) throws Exception {
		return userDAOImpl.getRole(userId);
	}

	@Override
	public boolean updatePassword(String username, String newPassword) 
	{
		return userDAOImpl.updateUserPassword(username, newPassword);
	}


}
