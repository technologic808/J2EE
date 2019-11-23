package com.acts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acts.dao.IActsDao;
import com.acts.pojos.Course;
import com.acts.pojos.Student;

@Service
@Transactional
public class ActsService implements IActsService {

	public ActsService() {
		System.out.println("In Service CTOR");
	}

	// Dependency Injection (Data Access Object) by type
	@Autowired
	private IActsDao dao;

	@Override
	public List<Course> getCourseList() {
		dao.getCourseList();
		return null;
	}

	@Override
	public void addStudent(Student student, Integer cId) {
		dao.addStudent(student, cId);
	}

	@Override
	public void deleteCourse(Integer cId) {
		dao.deleteCourse(cId);
	}

	@Override
	public Boolean validateStudent(Student student) {
		return true;
	}

	public IActsDao getDao() {
		return dao;
	}

	public void setDao(IActsDao dao) {
		this.dao = dao;
	}

}
