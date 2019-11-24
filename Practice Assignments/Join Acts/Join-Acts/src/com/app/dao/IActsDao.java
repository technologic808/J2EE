package com.app.dao;

import java.util.List;

import com.app.pojos.Course;
import com.app.pojos.Student;

public interface IActsDao {

	public List<Course> getCourseList();

	public void addStudent(Student student, Integer cId);

	public void deleteCourse(Integer cId);

}
