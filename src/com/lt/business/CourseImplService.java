package com.lt.business;

import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Course;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.CourseDAOInterface;

public class CourseImplService implements CourseInterface {


	List<Course> course1 = new ArrayList<Course>();
	Course objt = new Course();	
	CourseDAOInterface daoCourse = new CourseDAOImpl();
	
	
	@Override
	public String createCourse() {

//		course.add( new Course("101", "physics"));
//		course.add( new Course("102", "Chemistry"));
//		course.add( new Course("103", "MAths"));
//		course.add( new Course("104", "Biology"));
//		course.add( new Course("105", "English"));


		return "Course Added....";
	}

	@Override
	public String listCourse() {
		for(Course  cs : course1){

			System.out.println("details of Course--> " +cs.getCourseCode() + " " +cs.getCourseName());
		}
		return "list course";
	}

	@Override
	public String updateCourse(Course courses) {
		if(courses!=null) {
			for(Course cs1: course1)
			{
				if(cs1.getCourseCode()==((Course) courses).getCourseCode())
				{
					cs1.setCourseName(((Course) courses).getCourseName());
				}
				//System.out.println(cs.getCourseId()+ "\n" + cs.getCourseName());

			}
		}
		return "Course Updated";
	}

	@Override
	public String deleteCourse(String CourseId) {

		System.out.println("details deleted of course--> "); 

		for(int i=0;i<course1.size();i++) {
			if(course1.contains(objt.getCourseCode())) {
				course1.remove(objt);
			}
		}
		/*for(int i=0;i<course.size();i++){
			if(course.get(i).getCourseId() == "CourseId");
			    course.remove(CourseId);
			    break;
	    }*/

		/*for(Course  cs : course){
			if(cs.getCourseId() == CourseId) {
				course.remove(cs);
			}
		}*/

		for(Course cs : course1){
			System.out.println("details of course--> "+cs.getCourseCode() + " " +cs.getCourseName());
		} 
		return "Course "+CourseId+" Delete Successfully... ";
	
       }

	@Override
	public List<Course> viewCourses() {
		// TODO Auto-generated method stub
		return daoCourse.getCourse();
	}
}
