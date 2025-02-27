package com.javalearning.springboot.crudemployeedemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalearning.springboot.crudemployeedemo.dao.EmployeeDAO;
import com.javalearning.springboot.crudemployeedemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// define employeedao field
	private EmployeeDAO employeeDao;

	// constructor injection
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> getEmployees() {

		return employeeDao.getEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int employeeId) {
		employeeDao.deleteEmployeeById(employeeId);
	}

}
