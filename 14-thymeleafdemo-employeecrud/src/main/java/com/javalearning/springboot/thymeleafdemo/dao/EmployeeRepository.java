package com.javalearning.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javalearning.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//that's it... no need to write any code
}
