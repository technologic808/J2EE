package com.app.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Employee;
import com.app.service.IService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	// Dependency Injection
	@Autowired
	private IService service;

	public EmployeeController() {
		System.out.println("In Controller constructor");
	}

	// request handling method to show list of departments
	@GetMapping("/departments") // @RequestMapping + method =get
	public String listDepartments(Model map) throws Exception {
		System.out.println("In GET list department controller method");
		map.addAttribute("list", service.getDepartmentList());
		return "/employee/departments";// separation of view layer
	}

	// request handling method to show hire form
	@GetMapping("/hire") // @RequestMapping + method =get
	public String hireEmployeeForm() throws Exception {
		System.out.println("In GET hireEmployeeForm controller method");
		return "/employee/hire";// separation of view layer
	}

	// request handling method to show hire form
	@PostMapping("/hire") // @RequestMapping + method =POST
	public String hireEmployeeProcess(@RequestParam String name, @RequestParam String email,
			@RequestParam String salary, @RequestParam String dob, @RequestParam String deptId) throws Exception {
		System.out.println("In GET hireEmployeeProcess controller method");
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Salary: " + salary);
		System.out.println("DOB: " + dob);
		System.out.println("DeptId: " + deptId);

		if (service.validateEmployee(Double.valueOf(salary), LocalDate.parse(dob))) {
			Employee employee = new Employee(name, Double.valueOf(salary), LocalDate.parse(dob));
			service.hireEmployee(employee, Integer.valueOf(deptId));
		}

		return "redirect:/employee/departments";
	}

}
