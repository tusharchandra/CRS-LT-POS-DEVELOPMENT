package com.lt.client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.lt.bean.Catlog;
import com.lt.bean.Course;
import com.lt.bean.GradeCard;
import com.lt.bean.RegisteredCourse;
import com.lt.bean.Student;
import com.lt.business.CourseImplService;
import com.lt.business.CourseInterface;
import com.lt.business.GradeCardImplService;
import com.lt.business.GradeCardInterface;
import com.lt.business.PaymentImplService;
import com.lt.business.PaymentInterface;
import com.lt.business.RegisteredCourseImplService;
import com.lt.business.RegisteredCourseInterface;
import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.dao.CoursecatalogDAOImpl;
import com.lt.dao.CoursecatalogDAOInterface;
import com.lt.dao.PaymentDAOImpl;
import com.lt.dao.PaymentDAOInterface;
import com.lt.dao.StudentDAOImpl;
import com.lt.dao.StudentDAOInterface;
import com.sun.org.apache.xml.internal.resolver.Catalog;

public class StudentMenu 
{
	Scanner in = new Scanner(System.in);

	private boolean is_course_registered;

	GradeCardInterface gradecard = new GradeCardImplService();
	RegisteredCourseInterface regCourse = new RegisteredCourseImplService();
	CourseInterface course = new CourseImplService();
	CoursecatalogDAOInterface daoCourseCatalog = new CoursecatalogDAOImpl();
	PaymentInterface payment = new PaymentImplService();
	PaymentDAOInterface daoPayment = new PaymentDAOImpl();
	StudentDAOInterface daoStudent = new StudentDAOImpl();
	public void studentChecklist(int studentId)
	{

		while (CRSApplication.isloggedin) 
		{
			System.out.println("\n"+"*********************");
			System.out.println("Welcome Student");
			System.out.println("*********************");
			System.out.println("Select the option");
			System.out.println("1. Course Registration"+"\n"+ "2. Drop Course"+"\n"+"3. View Registerd Course"+"\n"+"4. View Grade Card"+"\n"+"5. Pay Fee"+"\n");
			int option = in.nextInt(); 

			switch(option)
			{
			case 1: 
				courseRegistration(studentId);
				break;

			case 2: 
				dropRegCourse(studentId);
				break;

			case 3: 
				viewRegistedCourse(studentId);
				break;

			case 4: 
				viewGradeCard(studentId);
				break;

			case 5: 
				if(daoPayment.paymentStatus(studentId)==null) {
					doPayment(studentId);
				}else {
					System.out.println("your Payment is Already Done....");
				}
				break;

			default:
				break;
			}
		}
	}

	public void doPayment(int studentId) {


		double fee =0.0;
		try
		{
			fee=payment.calculateFee(studentId);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}

		if(fee == 0.0)
		{
			System.out.println("You have not  registered for any courses yet");
		}
		else
		{
			System.out.println("Your total fee  = " + fee);
			payment.getPayment(studentId,fee);

		}

	}

	private void viewGradeCard(int studentId) {

		List<GradeCard> gradecardlist=null;

		try 
		{
			gradecardlist = gradecard.viewGradeCard(studentId);
		} 
		catch (Exception e) 
		{

			System.out.println(e.getMessage());
		}

		System.out.println(String.format("%-20s %-20s %-20s","COURSE CODE", "COURSE NAME", "GRADE"));

		if(gradecardlist.isEmpty())
		{
			System.out.println("You haven't registered for any course");
			return;
		}

		for(GradeCard obj : gradecardlist)
		{
			System.out.println(String.format("%-20s %-20s %-20s",obj.getCourseCode(), obj.getCourseName(),obj.getGrade()));
		}

	}

	private void semRegistration(int studentId) {
		// TODO Auto-generated method stub

	}


	private void courseRegistration(int studentId) { 
		
		List<Course>courseList=viewCourses();
		
		List<RegisteredCourse> registeredCourseList=null;
		try 
		{
			registeredCourseList = regCourse.viewRegCourses(studentId);
		}
		catch (SQLException e) 
		{

			System.out.println(e.getMessage());
		}
		int count = registeredCourseList.size();

		if(courseList.isEmpty())
		{
			System.out.println("NO COURSE AVAILABLE");
		}

		if(registeredCourseList.size()>6) {

			System.out.println("Maximum Course Added...");
		}

		if(course.viewCourses()!=null || registeredCourseList.size()>6){
			while(count < 6) 
			{
				try
				{ 
					System.out.println("Choose Course Code From Above List: " + (count+1)); 
					String courseCode =in.next();
					
					if(regCourse.addCourse(courseCode,studentId, courseList, registeredCourseList))  
					{
						System.out.println("Course " + courseCode + " registered sucessfully.");
						count++; 
					}
					else
					{
						System.out.println(" You have already registered for Course : " +courseCode); 
					}
				}
				catch (Exception e) {
					System.out.println(e.getMessage()); 
				}
			}
		}
		is_course_registered = true;

	}

	private void dropRegCourse(int studentId) 
	{

		try {
			if(regCourse.viewRegCourses(studentId)!=null)
			{
				List<RegisteredCourse> registeredCourseList=viewRegistedCourse(studentId);

				if(registeredCourseList==null)
					return;

				System.out.println("Enter the Course Code : ");
				String courseCode = in.next();

				try
				{
					if(regCourse.dropCourse(courseCode, studentId,registeredCourseList)) {
						System.out.println("You have successfully dropped Course : " + courseCode);
					}
				}
				//			catch(CourseNotFoundException e)
				catch (Exception e) 
				{
					System.out.println("You have not registered for course : " + e.getMessage());
				} 
			}
			else
			{
				System.out.println("No courseAvailable to delete...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	private List<RegisteredCourse> viewRegistedCourse(int studentId)
	{
		List<RegisteredCourse> available_course=null;
		try 
		{
			available_course = regCourse.viewRegCourses(studentId);
		}
		catch (SQLException e) 
		{

			System.out.println(e.getMessage());
		}


		if(available_course.isEmpty())
		{
			System.out.println("NO COURSE AVAILABLE");
			return null;
		}


		System.out.println("COURSE CODE     COURSE NAME     COURSE FEE");
		System.out.println("-----------     -----------     ----------");
		for(RegisteredCourse obj : available_course)
		{
			System.out.println(obj.getCourseId()+"     "+obj.getCourseName()+"      "+obj.getCourseFee());
		}

		return available_course;

	}

	public List<Course> viewCourses()
	{
		List<Course> available_course=null;
		try 
		{
			available_course = course.viewCourses();
		}
		catch (Exception e) 
		{

			System.out.println(e.getMessage());
		}


		if(available_course.isEmpty())
		{
			System.out.println("NO COURSE AVAILABLE");
			return null;
		}


		System.out.println(String.format("%20s %20s ","-----------","-----------"));
		System.out.println(String.format("%20s %20s ","COURSE CODE","COURSE NAME"));
		System.out.println(String.format("%20s %20s ","-----------","-----------"));
		for(Course obj : available_course)
		{
			System.out.println(String.format("%20s %20s ",obj.getCourseCode(),obj.getCourseName()));
		}

		return available_course;

	}
	
	public List<Catlog> viewCoursesCatalog()
	{
		List<Catlog> available_course=null;
		try 
		{
			available_course = daoCourseCatalog.viewCourses();
		}
		catch (Exception e) 
		{

			System.out.println(e.getMessage());
		}


		if(available_course.isEmpty())
		{
			System.out.println("NO COURSE AVAILABLE");
			return null;
		}


		System.out.println("COURSE CODE     COURSE NAME");
		System.out.println("-----------     -----------");
		for(Catlog obj : available_course)
		{
			System.out.println(obj.getCourseCode()+"     "+obj.getCourseName());
		}

		return available_course;

	}
	
	public List<Student> viewnotApprovedStudent()
	{
		List<Student> available_student=null;
		try 
		{
			available_student = daoStudent.getNotApprovedStudentList();
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}


		if(available_student.isEmpty())
		{
			System.out.println("all students are approved....");
			return null;
		}

		System.out.println("List of the Student which is not approved...");
		System.out.println("Student         Student_Name");
		System.out.println("-----------     -----------");
		for(Student obj : available_student)
		{
			System.out.println(obj.getStudentId()+"     "+obj.getStudentName());
		}

		return available_student;

	}



}
