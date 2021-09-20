package com.lt.business;

import java.util.Scanner;

import com.lt.bean.Admin;
import com.lt.bean.Catlog;
import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.client.AdminMenu;
import com.lt.dao.AdminDAOImpl;
import com.lt.dao.AdminDAOInterface;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.CourseDAOInterface;
import com.lt.dao.CoursecatalogDAOImpl;
import com.lt.dao.CoursecatalogDAOInterface;
import com.lt.dao.ProfessorDAOImpl;
import com.lt.dao.ProfessorDAOInterface;
import com.lt.dao.StudentDAOImpl;
import com.lt.dao.StudentDAOInterface;
import com.lt.dao.UserDAOImpl;
import com.lt.dao.UserDAOInterface;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of Admin Operations
 * 
 */
public class AdminImplService implements AdminInterface
{

	CourseInterface course1 = new CourseImplService();
	Course course=new Course();
    AdminDAOInterface ai=new AdminDAOImpl();
    
    /**
	 * Method to approve a Student 
	 * @param studentName
	 * @throws StudentNotFoundException 
	 */
	@Override
	public boolean approveStudent(int studentId) 
	{
		return ai.adminApproval(studentId);
		
	}
	
	/**
	 * Method to add professor to user DB
	 * @param name,password,contact,emailId,address
	 * @throws UserNotAddedException
	 */
	@Override
	public boolean addProfessor(String name, String password)
	{
		
		boolean checkProf=true;
        int profRole=2;
        UserDAOInterface d1=new UserDAOImpl();
        for(User u: d1.getUserCredential())
        {
            if(u.getUsername().equalsIgnoreCase(name))
            {
                 checkProf=false;
                 break;
            }
        }
        if(checkProf)
        {
            d1.signupUser(name, password, profRole);
            checkProf=true;
        }
        return checkProf;
	}
	
	/**
	 * Method to add Course to Course 
	 * @param courseId
	 * @throws CourseFoundException
	 */
	@Override
	public void addCourses() throws CourseFoundException 
	{
		AdminDAOInterface adminDao=new AdminDAOImpl();
		CoursecatalogDAOInterface ci=new CoursecatalogDAOImpl();
		System.out.println("Select the option from below course list");	
		System.out.println("CourseId  "+"|"+" CourseName");
		System.out.println("----------------------------");
		for(Catlog c:ci.viewCourses())
		{
				System.out.println(c.getCourseCode()+"         | "+c.getCourseName());
			
		}
		System.out.println("Enter the CourseId from the list to be added");
		Scanner in = new Scanner(System.in);
		String CourseCode = in.next();
		for(Catlog catlog : ci.viewCourses())
		{
			if(CourseCode.equals(catlog.getCourseCode()))
			{
				String CourseName=catlog.getCourseName();
				//String ProfName=
				double CourseFee = catlog.getCourseFee();
				if(adminDao.addCourse(CourseCode,CourseName,CourseFee))
				{
					System.out.println("course Added Sucessfully......");
					break;
				}
				else
					System.out.println("Course was not added, please try again!!");
			}	
		}		
	}
	
	
	/**
	 * Method to Delete Course from Course 
	 * @param courseId
	 * @throws CourseNotFoundException 
	 */
	@Override
	public void deleteCourses() throws CourseNotFoundException 
	{
		AdminDAOInterface adminDao1=new AdminDAOImpl();
		System.out.println("Select the courseId to be deleted"+"\n");
		CourseDAOInterface c1=new CourseDAOImpl();
		System.out.println("CourseCode  "+"|"+" CourseName");
		System.out.println("----------------------------");
		for(Course course : c1.getCourse())
		{
		
				System.out.println(course.getCourseCode()+"        | "+course.getCourseName());
			
		}
		System.out.println("Enter the CourseId from the list to be deleted");
		Scanner in = new Scanner(System.in);
		String CourseId = in.next();	
		for(Course cc:c1.getCourse())
		{
			if(CourseId.equals(cc.getCourseCode()))
			{
				String courseName=cc.getCourseName();
				if(adminDao1.deleteCourse(CourseId,courseName))
				{
					System.out.println("Course have been deleted Successfully..");
					break;
				}
				else {
					System.out.println("Course was not deleted, please try again!!");
				}
			}
		}					
	}
	
	
	
	
	
	
	
	
}