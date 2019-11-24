package com.app.services;

import java.util.List;

import com.app.pojos.Course;
import com.app.pojos.Student;

public interface IActsService {

	public List<Course> getCourseList();

	public void addStudent(Student student, Integer cId);

	public void deleteCourse(Integer cId);

	// Business Logic Methods

	public Boolean validateStudent(Student student);

}
