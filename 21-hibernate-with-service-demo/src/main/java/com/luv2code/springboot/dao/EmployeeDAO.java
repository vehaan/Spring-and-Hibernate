package com.luv2code.springboot.dao;

import java.util.List;

import com.luv2code.springboot.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);

}
