package com.app.service;

import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDao;
import com.app.pojos.Department;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeService implements IService {

	// Dependency Injection
	@Autowired // by type
	private IDao dao;

	// Checks if salary of employee is between 20K to 30K and DOB year is less than
	// 95

	public EmployeeService() {
		System.out.println("In Service constructor");
	}

	@Override
	public Boolean validateEmployee(Double salary, LocalDate dob) {
		System.out.println("in vali emp service method");
		if (salary > 20000 && salary < 30000 && dob.isBefore(parse("1995-12-31")))
			return true;
		else
			return false;
	}

	@Override
	public List<Department> getDepartmentList() throws Exception {
		System.out.println("in get dept service method");
		return dao.getDepartmentList();
	}

	@Override
	public String hireEmployee(Employee employee, Integer deptId) {
		System.out.println("in hire emp service method");
		return dao.hireEmployee(employee, deptId);
	}

}
