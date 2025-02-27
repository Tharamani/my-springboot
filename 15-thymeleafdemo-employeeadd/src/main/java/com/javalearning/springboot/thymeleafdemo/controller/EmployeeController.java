package com.javalearning.springboot.thymeleafdemo.controller;

import javax.management.RuntimeErrorException;

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

		//get employees from db
		model.addAttribute("employees", eService.findAll());
		return "employees/list-employees";
	}
	
	//map GET /employees/showFormForAdd
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		//create model attribute to bind form data
		model.addAttribute("employee", new Employee());
		return "employees/employee-form";
	}
	
	//map POST /employees/save
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		//save the employee
		if(employee.getFirstName().equalsIgnoreCase("") || employee.getLastName().equalsIgnoreCase("")
				|| employee.getEmail().equalsIgnoreCase("")) {
			throw new RuntimeException("Fill Employee details");
		}
		eService.save(employee);
		
		//use a redirect to prevent duplicates submissions
		return "redirect:/employees/list";
	}
}
