package com.javalearning.springboot.crudemployeedemo.dao;

import java.util.List;

import com.javalearning.springboot.crudemployeedemo.entity.Employee;

public interface EmployeeDAO {

	public  List<Employee> getEmployees();
	
	public  Employee getEmployeeById(int employeeId);
	
	public  void saveEmployee(Employee employee);
	
	public  void deleteEmployeeById(int employeeId);
}
