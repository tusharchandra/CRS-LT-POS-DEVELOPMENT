package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Catlog;
import com.lt.utils.DBUtil;

public class CoursecatalogDAOImpl implements CoursecatalogDAOInterface
{
	static List<Catlog> catalogList= new ArrayList<>();
	@Override
	public List<Catlog> viewCourses()
	{
		Connection conn = DBUtil.getConnection();
		try 
		{
			String str = "select course_code, course_name, course_fee from course_catalog";
			PreparedStatement myStmt = conn.prepareStatement(str);
			ResultSet myRs = myStmt.executeQuery();

			while(myRs.next())
			{
				String courseCode = myRs.getString(1); 
				String courseName = myRs.getString(2);
				double courseFee = myRs.getDouble(3); 
				catalogList.add(new Catlog(courseCode,courseName,courseFee));	
			}
		} 
		catch (SQLException ex) 
		{
			System.out.println("Exception occurred....");
		} 

		return catalogList; 

	}


}
