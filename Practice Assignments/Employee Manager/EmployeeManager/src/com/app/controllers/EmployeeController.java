package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
