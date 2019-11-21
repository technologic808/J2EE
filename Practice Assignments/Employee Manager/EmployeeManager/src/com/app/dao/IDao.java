package com.app.dao;

import java.util.List;

import com.app.pojos.Department;
import com.app.pojos.Employee;

public interface IDao {

	// Gets Department list
	public List<Department> getDepartmentList() throws Exception;

	// Hires employee
	public String hireEmployee(Employee employee);

	// Business Logic methods

	// None

}
