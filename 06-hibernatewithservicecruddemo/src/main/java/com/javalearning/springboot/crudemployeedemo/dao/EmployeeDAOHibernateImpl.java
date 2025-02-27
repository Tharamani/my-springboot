package com.javalearning.springboot.crudemployeedemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javalearning.springboot.crudemployeedemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager manager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Employee> getEmployees() {
		// get the current hibernate session
		Session session = manager.unwrap(Session.class);

		// create a query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = query.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// get the current hibernate session
		Session session = manager.unwrap(Session.class);

		System.out.println("DAO=======> " + employeeId);
		// get employee
		Employee employee = session.get(Employee.class, employeeId);
		System.out.println("DAO=======> " + employee.getFirstName());
		// return employee
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		// get the current hibernate session
		Session session = manager.unwrap(Session.class);

		// save employee ,i fPK = 0 save or else update
		session.saveOrUpdate(employee);

	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		// get the current hibernate session
		Session session = manager.unwrap(Session.class);

		// delete employee object with PK
		Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", employeeId);

		// return employee
		query.executeUpdate();
	}

}
