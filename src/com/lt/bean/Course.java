package com.lt.bean;

public class Course {

	private String CourseCode;
	private String CourseName;
	private String ProgId;
	public double CourseFee;

	public Course() {}

	public Course(String courseId, String courseName) {
		super();
		CourseCode = courseId;
		CourseName = courseName;
	}



	public Course(String courseCode, String courseName, String progId) {
		super();
		CourseCode = courseCode;
		CourseName = courseName;
		ProgId = progId;
	}

	public String getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(String courseId) {
		CourseCode = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getProgId() {
		return ProgId;
	}

	public void setProgId(String progId) {
		ProgId = progId;
	}

	public double getCourseFee() {
		return CourseFee;
	}

	public void setCourseFee(double courseFee) {
		CourseFee = courseFee;
	}

	@Override
	public String toString() {
		return "Course [CourseCode=" + CourseCode + ", CourseName=" + CourseName + "]";
	}


}
