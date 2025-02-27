package com.javalearning.springboot.crudemployeedemo.service;

import java.util.List;

import com.javalearning.springboot.crudemployeedemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee getEmployeeById(int employeeId);

	public void saveEmployee(Employee employee);

	public void deleteEmployeeById(int employeeId);
}
