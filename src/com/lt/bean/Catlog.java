package com.lt.bean;

public class Catlog {

	
	public String CourseCode;
	public String CourseName;
	public double CourseFee;
	
	
	
	
	public Catlog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Catlog(String courseCode, String courseName, double courseFee) {
		super();
		CourseCode = courseCode;
		CourseName = courseName;
		CourseFee = courseFee;
	}
	public String getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public double getCourseFee() {
		return CourseFee;
	}
	public void setCourseFee(double courseFee) {
		CourseFee = courseFee;
	} 
	
	
	
	
}
