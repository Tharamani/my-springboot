package com.javalearning.springboot.crudemployeedemo.service;

import java.util.List;

import com.javalearning.springboot.crudemployeedemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int employeeId);

	public void save(Employee employee);

	public void deleteById(int employeeId);
}
