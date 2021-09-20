package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.utils.DBUtil;
import com.lt.bean.Course;
import com.lt.bean.RegisteredCourse;
import com.lt.constants.SQLQueriesConstants;

/**
 * 
 * Class to implement Professor DAO Service
 *
 */
public class ProfessorDAOImpl implements ProfessorDAOInterface {


	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	/**
	 * Default Constructor
	 */
	//	private ProfessorDAOImpl()
	//	{
	//		
	//	}

	/**
	 * Method to get Courses by Professor Id using SQL Commands
	 * @param userId, prof id of the professor
	 * @return get the courses offered by the professor.
	 */
	@Override
	public List<Course> getCoursesByProfessor(String profId) {
		Connection connection=DBUtil.getConnection();
		List<Course> courseList=new ArrayList<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_COURSES);

			statement.setString(1, profId);

			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				courseList.add(new Course(results.getString("courseId"),results.getString("courseName"),results.getString("professorId")));
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}

		return courseList;

	}

	/**
	 * Method to view list of enrolled Students using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 */
	@Override
	public List<RegisteredCourse> getRegisteredCourses(String profId) {

		List<RegisteredCourse> enrolledStudents=new ArrayList<RegisteredCourse>();

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try {
			connection=DBUtil.getConnection();
			String query = "select course_code, course_name, student_id from registered_course where course_code IN (select course_code from course where prof_id = ? )";     
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, profId);

			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				enrolledStudents.add(new RegisteredCourse(resultSet.getString("course_code"),resultSet.getString("course_name"),resultSet.getInt("student_id")));
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}

		return enrolledStudents;
	}

	/**
	 * Method to Grade a student using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code for the corresponding 
	 * @return: returns the status after adding the grade
	 */
	public Boolean addGrade(int studentId,String courseId,String grade) {
		Connection connection=DBUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.ADD_GRADE);

			statement.setString(1, grade);
			statement.setString(2, courseId);
			statement.setInt(3, studentId);

			int row = statement.executeUpdate();

			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}

		return false;
	}


	/**
	 * Method to Get professor name by id
	 * @param profId
	 * @return
	 */
	@Override
	public String getProfessorById(String profId)
	{
		String prof_Name = null;
		Connection connection=DBUtil.getConnection();
		try 
		{
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_PROF_NAME);

			statement.setString(1, profId);
			ResultSet rs = statement.executeQuery();
			rs.next();

			prof_Name = rs.getString(1);

		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}

		return prof_Name;
	}
}

