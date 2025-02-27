package com.javalearning.springboot.crudemployeedemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javalearning.springboot.crudemployeedemo.entity.Employee;

@Repository
public class EmployeeDAOJAPImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOJAPImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getEmployees() {
		Query query = entityManager.createQuery("from Employee");
		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {

		// get employee from db using PK
		Employee employee = entityManager.find(Employee.class, employeeId);

		// check for exception
		if (employee == null) {
			throw new RuntimeException("Employee Id not forund : " + employeeId);
		}
		// happy flow
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {

		// save or update employee
		Employee dbEmployee = entityManager.merge(employee);

		// update with id from db....so we can get generated id for save / insert
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteEmployeeById(int employeeId) {

		//delete the object with PK
		Query query = entityManager.createQuery(" delete from Employee where id=:employeeId");
		query.setParameter("employeeId", employeeId);
		query.executeUpdate();
	}

}
