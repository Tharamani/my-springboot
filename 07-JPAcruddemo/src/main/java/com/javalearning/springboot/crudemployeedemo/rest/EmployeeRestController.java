package com.javalearning.springboot.crudemployeedemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalearning.springboot.crudemployeedemo.entity.Employee;
import com.javalearning.springboot.crudemployeedemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// quick and dirty: inject employeeService

	private EmployeeService employeeService;

	// constructor injection'
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {

		return employeeService.getEmployees();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {

		Employee employee = employeeService.getEmployeeById(employeeId);
		if (employee == null) {
			throw new RuntimeException(" employeeId is not found " + employeeId);
		}
		return employee;
	}

	// add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {

		// also just in case they pass an id in JSON... set id = 0
		// this is to force a save item... instead of update

		employee.setId(0);
		employeeService.saveEmployee(employee);

		return employee;
	}

	// add mapping for pUT /employees - update existing employee
	@PutMapping("/employees")
	public Employee updateEmployeeById(@RequestBody Employee employee) {

		employeeService.saveEmployee(employee);

		return employee;
	}

	// add mapping for Delete /employees - delete existing employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {

		Employee employee = employeeService.getEmployeeById(employeeId);
		if (employee == null) {
			throw new RuntimeException(" employeeId is not found " + employeeId);
		}
		employeeService.deleteEmployeeById(employeeId);
		return "Deleted employee id - : " + employeeId ;
	}
}
