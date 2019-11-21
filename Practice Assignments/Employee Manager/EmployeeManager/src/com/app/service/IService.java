package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Department;
import com.app.pojos.Employee;

public interface IService {

	// Gets Department list
	public List<Department> getDepartmentList() throws Exception;

	// Hires employee
	public String hireEmployee(Employee employee, Integer deptId);

	// Business logic

	// Checks if salary of employee is between 20K to 30K and DOB year is less than
	// 95

	public Boolean validateEmployee(Double salary, LocalDate dob);

}
