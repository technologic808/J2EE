package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Student;
import com.app.services.IActsService;

@Controller
@RequestMapping("/courses")
public class ActsController {

	public ActsController() {
		System.out.println("In Controller CTOR");
	}

	// Dependency Injection (Service Layer) by type
	@Autowired
	public IActsService service;

	@GetMapping("/list")
	public String getCourseList(Model model) {
		System.out.println("In Controller getCourseList");
		model.addAttribute("courses", service.getCourseList());
		return "/courses/list"; // Separation of view layer and controller
	}

	@GetMapping("/delete")
	public String deleteCourse(@RequestParam String cId) {
		System.out.println("In Controller deleteCourse");
		service.deleteCourse(Integer.parseInt(cId));
		return "redirect:/courses/list"; // Separation of view layer and controller
	}

	@GetMapping("/admission")
	public String admitStudentForm(@RequestParam String cId, Model map) {
		System.out.println("In Controller admitStudentForm");
		map.addAttribute("cId", cId);
		map.addAttribute("student", new Student());
		return "/courses/admission"; // Separation of view layer and controller
	}

	@PostMapping("/admission")
	public String admitStudentProcess(@ModelAttribute Student student, @RequestParam String cId) { // Two way form
		System.out.println("In Controller admitStudentProcess");
		System.out.println("Student model attribute from form: " + student); // binding
		
		if (service.validateStudent(student))
			service.addStudent(student, Integer.parseInt(cId));
		return "redirect:/courses/list"; // Separation of view layer and controller
	}

}
