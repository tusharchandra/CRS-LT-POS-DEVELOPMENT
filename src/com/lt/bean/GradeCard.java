package com.lt.bean;

public class GradeCard {

	private int StudentId;
	private String CourseCode;
	private String CourseName;
	private String Grade;

	public GradeCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GradeCard(String courseCode, String courseName, String grade) {
		CourseCode = courseCode;
		CourseName = courseName;
		Grade = grade;
	}

	public GradeCard(int studentId, String courseCode, String courseName, String grade) {
		super();
		StudentId = studentId;
		CourseCode = courseCode;
		CourseName = courseName;
		Grade = grade;
	}

	public int getStudentId() {
		return StudentId;
	}


	public void setStudentId(int studentId) {
		StudentId = studentId;
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


	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	@Override
	public String toString() {
		return "GradeCard [StudentId=" + StudentId + ", CourseId=" + CourseCode + ", Grade=" + Grade + "]";
	}


}
