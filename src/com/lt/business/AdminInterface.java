package com.lt.business;

import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;

/**
 * 
 * @author G4-FullStackGroup
 * Interface for Admin Operations
 * 
 */
public interface AdminInterface 
{
	
	/**
	 * Method to add Professor to DB
	 * @param professor : Professor Object storing details of a professor
	 */
	public boolean addProfessor(String name,String password);
	
	/**
	 * Method to approve a Student 
	 * @param studentId
	 * @return 
	 * @throws StudentNotFoundException 
	 */
	public boolean approveStudent(int studentId);
	
	/**
	 * Method to add Course from Course Catalog
	 * @param course : Course object storing details of a course
	 * @throws CourseFoundException 
	 */
	public void addCourses() throws CourseFoundException;
	
	/**
	 * Method to Delete Course from Course 
	 * @param courseCode
	 * @throws CourseNotFoundException 
	 */
	public void deleteCourses() throws CourseNotFoundException;
}