package com.acts.services;

import java.util.List;

import com.acts.pojos.Course;
import com.acts.pojos.Student;

public interface IActsService {

	public List<Course> getCourseList();

	public void addStudent(Student student, Integer cId);

	public void deleteCourse(Integer cId);

	// Business Logic Methods

	public Boolean validateStudent(Student student);

}
