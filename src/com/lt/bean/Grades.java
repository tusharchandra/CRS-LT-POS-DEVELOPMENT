package com.lt.bean;

public class Grades {

	private int StudentId;
	private String Grade;
	private String CourseId;
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	@Override
	public String toString() {
		return "Grades [StudentId=" + StudentId + ", Grade=" + Grade + ", CourseId=" + CourseId + "]";
	}
	
	
}
