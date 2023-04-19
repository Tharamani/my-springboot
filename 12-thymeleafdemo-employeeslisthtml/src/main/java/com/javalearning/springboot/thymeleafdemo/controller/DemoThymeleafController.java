package com.javalearning.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalearning.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class DemoThymeleafController {

	private List<Employee> employeeList;

	// load employee data
	@PostConstruct
	private void loadData() {
		// create the list
		employeeList = new ArrayList<Employee>();

		// add employees to list
		employeeList.add(new Employee(1, "Arnav", "V", "arnav@gmail.com"));
		employeeList.add(new Employee(2, "Vish", "D K", "vish@gmail.com"));
		employeeList.add(new Employee(3, "Tara", "M P", "tara@gmail.com"));

	}

	// create a mapping for hello
	@GetMapping("/hello")
	public String sayHello(Model model) {

		model.addAttribute("serverDate", new java.util.Date());
		return "helloworld";
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model model) {

		model.addAttribute("employees", employeeList);
		return "list-employees";
	}
}
