package com.lt.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.RegisteredCourse;
import com.lt.dao.ProfessorDAOImpl;
import com.lt.dao.ProfessorDAOInterface;
import com.lt.exception.GradeNotAddedException;

public class ProfessorImplService implements ProfessorInterface {

	ProfessorDAOInterface professorDAOInterface=new ProfessorDAOImpl();
	
//	private ProfessorImplService()
//	{
//
//	}
	/**
	 * Method to grade a Student
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 * @return boolean indicating if grade is added or not
	 * @throws GradeNotAddedException
	 */
	@Override
	public boolean addGrade(int studentId,String courseId,String grade) throws GradeNotAddedException {
		try
		{
			professorDAOInterface.addGrade(studentId, courseId, grade);
		}
		catch(Exception ex)
		{
			throw new GradeNotAddedException(studentId);
		}
		return true;
	}
	
	
	/**
	 * Method to view all the enrolled students
	 * @param profId: professor id 
	 * @return List of enrolled students
	 */
	@Override
	public List<RegisteredCourse> getRegisteredCourses(String profId) throws SQLException{
		List<RegisteredCourse> enrolledStudents=new ArrayList<RegisteredCourse>();
		try
		{
			enrolledStudents=professorDAOInterface.getRegisteredCourses(profId);
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return enrolledStudents;
	}

	
	/**
	 * Method to get list of all course a professor is teaching
	 * @param profId: professor id 
	 * @return List of courses the professor is teaching
	 */
	@Override
	public List<Course> getCourses(String profId) {
		//call the DAO class
		//get the courses for the professor
		List<Course> coursesOffered=new ArrayList<Course>();
		try
		{
			coursesOffered=professorDAOInterface.getCoursesByProfessor(profId);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return coursesOffered;
	}
	
	/**
	 * Method to get the professor name with ID
	 * @param profId
	 * @return Professor name 
	 */
	@Override
	public String getProfessorById(String profId)
	{
		return professorDAOInterface.getProfessorById(profId);
	}
}
