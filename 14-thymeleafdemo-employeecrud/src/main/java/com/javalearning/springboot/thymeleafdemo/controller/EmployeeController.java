package com.javalearning.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalearning.springboot.thymeleafdemo.entity.Employee;
import com.javalearning.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService eService;

	@Autowired
	public EmployeeController(EmployeeService eService) {
		this.eService = eService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model model) {

		// get employees from db
		model.addAttribute("employees", eService.findAll());
		return "list-employees";
	}
}
