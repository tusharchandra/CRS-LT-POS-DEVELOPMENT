package com.lt.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.RegisteredCourse;
import com.lt.business.ProfessorImplService;
import com.lt.business.ProfessorInterface;
import com.lt.exception.GradeNotAddedException;

/**
 * 
 * Class that display Professor Client Menu
 * 
 */
public class ProfessorMenu {

	private static Logger logger = Logger.getLogger(ProfessorMenu.class);
	ProfessorInterface professorInterface= new ProfessorImplService();
	/**
	 * Method to create Professor Checklist
	 * @param profId: professor id obtained after logging into the system
	 * returns displays all the options for the professor, and provides navigation
	 */
	public void professorChecklist(String profId)
	{
		System.out.println("*************Welcome Professor************");
		System.out.println("******************************************");
		System.out.println("Select the option");
		System.out.println("1. View Registered Courses by Student"+"\n"+ "2. Add Grades"+"\n"+"3. View Course"+"\n"+"4. Logout"+"\n");

		//Display the options available for the Professor
		Scanner sc = new Scanner(System.in);

		//user input
		int option = sc.nextInt(); 
		switch(option)
		{
		case 1: System.out.println("View Registered Courses by Studens"+"\n");
		//view all the enrolled students for the course
		viewRegisteredCourses(profId);
		break;

		case 2: System.out.println("Add Grades"+ "\n");
		//add grade for a student
		addGrade();
		break;

		case 3: System.out.println("View Course"+"\n");
		//view all the courses taught by the professor
		getCourses(profId);
		break;

		case 4: 
			//logout from the system
			break;
		}
	}
	/**
	 * Method to view courses registered by Students
	 * @param profId
	 */
	public void viewRegisteredCourses(String profId)
	{
		List<Course> coursesEnrolled=professorInterface.getCourses(profId);
		try
		{
			List<RegisteredCourse> enrolledStudents=new ArrayList<RegisteredCourse>();
			enrolledStudents=professorInterface.getRegisteredCourses(profId);
			logger.info(String.format("%20s %20s %20s","COURSE ID","COURSE NAME","Student ID" ));
			System.out.println(String.format("%20s %20s %20s","COURSE ID","COURSE NAME","Student ID" ));
			for(RegisteredCourse obj: enrolledStudents)
			{
				logger.info(String.format("%20s %20s %20s",obj.getCourseId(), obj.getCourseName(),obj.getStudentId()));
				System.out.println(String.format("%20s %20s %20s",obj.getCourseId(), obj.getCourseName(),obj.getStudentId()));
			}

		}
		catch(Exception ex)
		{
			logger.error(ex.getMessage()+"Something went wrong, please try again later!");
		}
	}

	/**
	 * Method to get list of all Courses Professor has to teach
	 * @param profId
	 */
	public void getCourses(String profId)
	{
		try
		{
			List<Course> coursesEnrolled=professorInterface.getCourses(profId);
			logger.info(String.format("%20s %20s %20s","COURSE ID","COURSE NAME","NO. ENROLLED" ));
			System.out.println(String.format("%20s %20s %20s","---------","-----------","------------" ));
			System.out.println(String.format("%20s %20s %20s","COURSE ID","COURSE NAME","NO. ENROLLED" ));
			System.out.println(String.format("%20s %20s %20s","---------","-----------","------------" ));
			for(Course obj: coursesEnrolled)
			{
				logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName()));
				System.out.println(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName()));
			}		
		}
		catch(Exception ex)
		{
			logger.error("Something went wrong!"+ex.getMessage());
		}
	}

	/**
	 * Method to help Professor grade a student
	 */
	public void addGrade()
	{
		Scanner sc=new Scanner(System.in);
		int studentId;
		String courseCode,grade;
		try
		{
			logger.info("----------------Add Grade--------------");
			logger.info("Enter student id");
			studentId=sc.nextInt();
			logger.info("Enter course code");
			courseCode=sc.next();
			logger.info("Enter grade");
			grade=sc.next();
			professorInterface.addGrade(studentId, courseCode, grade);
			logger.info("Grade added successfully for "+studentId);

		}
		catch(GradeNotAddedException ex)
		{
			logger.error("Grade cannot be added for"+ex.getStudentId());

		}

	}
}
