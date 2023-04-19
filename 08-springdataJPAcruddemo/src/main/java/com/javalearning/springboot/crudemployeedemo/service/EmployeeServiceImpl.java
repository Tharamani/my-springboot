package com.javalearning.springboot.crudemployeedemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalearning.springboot.crudemployeedemo.dao.EmployeeRepository;
import com.javalearning.springboot.crudemployeedemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// define employeedao field
	private EmployeeRepository employeeRepository;

	// constructor injection
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		Optional<Employee> optionalEntity= employeeRepository.findById(employeeId);
		return optionalEntity.get();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
