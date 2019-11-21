package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
import com.app.pojos.Employee;

@Repository
public class Dao implements IDao {

	// Dependency Injection
	@Autowired // by type
	private SessionFactory sf;

	public Dao() {
		System.out.println("In DAO constructor");
	}

	// Gets List of Departments from Database
	@Override
	public List<Department> getDepartmentList() throws Exception {

		System.out.println("in get dept list dao method");

		List<Department> departments = null;

		String jpqlString = "SELECT department from Department department";

		departments = sf.getCurrentSession().createQuery(jpqlString, Department.class).getResultList();

		if (departments != null)
			return departments;
		else
			throw new Exception("Not able to fetch department list");
	}

	@Override
	public String hireEmployee(Employee employee, Integer deptId) {

		System.out.println("in hire emp dao method");
		Department department = sf.getCurrentSession().get(Department.class, deptId);
//		employee.setDepartment(department); 
		department.addEmployee(employee); // Aditya : "Believe me!! This works!!" And it did...
		department.setStrength(department.getStrength() + 1);
		sf.getCurrentSession().save(department);
//
//		if (identifier != null)
//			return "Employee hired successfully";
//		else
//			return "Employee not hired";
		return null;
	}

}
