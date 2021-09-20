package com.lt.bean;

import java.util.Date;

public class RegisteredCourse {

	private String CourseId;
	private String CourseName;
	private Date DateOfRegistration;
	private String CourseFee;
	private String Grade;
	private int StudentId;


	public RegisteredCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public RegisteredCourse(String courseId, String courseName, int studentId) {
		super();
		CourseId = courseId;
		CourseName = courseName;
		StudentId = studentId;
	}



	public RegisteredCourse(String courseId, String courseName,  String courseFee) {
		super();
		CourseId = courseId;
		CourseName = courseName;
		CourseFee = courseFee;
		
	}

	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public Date getDateOfRegistration() {
		return DateOfRegistration;
	}
	public void setDateOfRegistration(Date dateOfRegistration) {
		DateOfRegistration = dateOfRegistration;
	}
	public String getCourseFee() {
		return CourseFee;
	}

	public void setCourseFee(String courseFee) {
		CourseFee = courseFee;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	@Override
	public String toString() {
		return "RegisteredCourse [CourseId=" + CourseId + ", CourseName=" + CourseName + ", DateOfRegistration="
				+ DateOfRegistration + ", CourseFee=" + CourseFee + ", Grade=" + Grade + "]";
	}



}
