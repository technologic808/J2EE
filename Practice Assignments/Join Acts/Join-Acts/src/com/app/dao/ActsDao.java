package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
import com.app.pojos.Student;

@Repository
public class ActsDao implements IActsDao {

	public ActsDao() {
		System.out.println("In DAO CTOR");
	}

	// Dependency Injection (<Http/...>SessionFactory) by type
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Course> getCourseList() {

		String jpqlString = "SELECT course from Course course";

		return sf.getCurrentSession().createQuery(jpqlString, Course.class).getResultList();
	}

	@Override
	public void addStudent(Student student, Integer cId) {
		Course course = sf.getCurrentSession().get(Course.class, cId);
		course.addStudent(student);
		sf.getCurrentSession().save(course);

	}

	@Override
	public void deleteCourse(Integer cId) {
		Course course = sf.getCurrentSession().get(Course.class, cId);
		sf.getCurrentSession().delete(course);
	}

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

}
