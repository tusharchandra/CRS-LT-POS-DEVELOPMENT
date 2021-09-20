package com.lt.exception;

/**
 * @author G4-FullStack
 *
 */
public class CourseFoundException extends Exception
{
private int courseId;
	
	public CourseFoundException(int courseId) {
		this.courseId = courseId;
	}
	
	public int getCourseCode() {
		return courseId;
	}
	
	@Override
	public String getMessage() {
		return "courseCode: " + courseId + " already present in catalog!";
	}

}
