package com.lt.constants;
/**
 * 
 * Class storing SQL Queries
 */

public class SQLQueriesConstants {
	//ProfessorDAO Queries
	public static final String GET_COURSES="select * from course where professorId in = ?";
	public static final String GET_ENROLLED_STUDENTS="select course.courseCode,course.courseName,registeredcourse.studentId from course inner join registeredcourse on course.courseCode = registeredcourse.courseCode where course.professorId in (select professorId from professor where userId = ?) order by course.courseCode";
	public static final String ADD_GRADE="update registeredcourse set Grade=? where courseCode=? and studentId=?";
	public static final String GET_PROF_NAME = "select name from user where userId in (select userId from professor where professorId = ?)";
	
}
