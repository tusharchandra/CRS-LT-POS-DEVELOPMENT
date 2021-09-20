package com.lt.bean;

public class Student {

	private int StudentId;
	private String StudentName;
	private String StudentEmailId;
	private String StudentAddress;
	private String Branch;
	private Long StudentContactNo;
	private int IsApproved;
	


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int studentId, String studentName, String studentEmailId, String studentAddress, String branch,
			Long studentContactNo) {

		StudentId = studentId;
		StudentName = studentName;
		StudentEmailId = studentEmailId;
		StudentAddress = studentAddress;
		Branch = branch;
		StudentContactNo = studentContactNo;
	}

	

	public Student(int studentId, String studentName) {
		super();
		StudentId = studentId;
		StudentName = studentName;
	}



	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public Long getStudentContactNo() {
		return StudentContactNo;
	}
	public void setStudentContactNo(Long studentContactNo) {
		StudentContactNo = studentContactNo;
	}
	public String getStudentEmailId() {
		return StudentEmailId;
	}
	public void setStudentEmailId(String studentEmailId) {
		StudentEmailId = studentEmailId;
	}
	public String getStudentAddress() {
		return StudentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}
	
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}

	public int getIsApproved() {
		return IsApproved;
	}
	public void setIsApproved(int isApproved) {
		IsApproved = isApproved;
	}

	
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", StudentContactNo="
				+ StudentContactNo + ", StudentEmailId=" + StudentEmailId + ", StudentAddress=" + StudentAddress + "]";
	}


}
