package com.lt.bean;

public class Notification {

	private int NotificationId;
	private String Message;
	private String Status;
	private int StudentId;
	public int getNotificationId() {
		return NotificationId;
	}
	public void setNotificationId(int notificationId) {
		NotificationId = notificationId;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	@Override
	public String toString() {
		return "Notification [NotificationId=" + NotificationId + ", Message=" + Message + ", Status=" + Status
				+ ", StudentId=" + StudentId + "]";
	}
	
	
}
