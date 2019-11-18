package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String  test() {
		System.out.println("Inside HelloController class");
		return "/home";
	}
	
}
