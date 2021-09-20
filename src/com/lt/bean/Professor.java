package com.lt.bean;

public class Professor {

	private int ProfessorId;
	private String ProfessorName;
	private Long ProfessorContactNo;
	private String ProfessorEmailId;
	private String ProfessorAddress;
	
	
	public int getProfessorId() {
		return ProfessorId;
	}
	public void setProfessorId(int professorId) {
		ProfessorId = professorId;
	}
	public String getProfessorName() {
		return ProfessorName;
	}
	public void setProfessorName(String professorName) {
		ProfessorName = professorName;
	}
	public Long getProfessorContactNo() {
		return ProfessorContactNo;
	}
	public void setProfessorContactNo(Long professorContactNo) {
		ProfessorContactNo = professorContactNo;
	}
	public String getProfessorEmailId() {
		return ProfessorEmailId;
	}
	public void setProfessorEmailId(String professorEmailId) {
		ProfessorEmailId = professorEmailId;
	}
	public String getProfessorAddress() {
		return ProfessorAddress;
	}
	public void setProfessorAddress(String professorAddress) {
		ProfessorAddress = professorAddress;
	}
	@Override
	public String toString() {
		return "Professor [ProfessorId=" + ProfessorId + ", ProfessorName=" + ProfessorName + ", ProfessorContactNo="
				+ ProfessorContactNo + ", ProfessorEmailId=" + ProfessorEmailId + ", ProfessorAddress="
				+ ProfessorAddress + "]";
	}
	
	
}
