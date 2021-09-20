package com.lt.bean;



public class SemesterRegistration 
{
	public SemesterRegistration(int studentId, String studentname, int semester) {
		super();
		this.studentId = studentId;
		Studentname = studentname;
		this.semester = semester;
	}
	private int studentId;
	private String Studentname;
	private int semester;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentname() {
		return Studentname;
	}
	public void setStudentname(String studentname) {
		Studentname = studentname;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
}
