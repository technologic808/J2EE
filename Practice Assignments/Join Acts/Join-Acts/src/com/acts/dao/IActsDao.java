package com.acts.dao;

import java.util.List;

import com.acts.pojos.Course;
import com.acts.pojos.Student;

public interface IActsDao {

	public List<Course> getCourseList();

	public void addStudent(Student student, Integer cId);

	public void deleteCourse(Integer cId);

}
