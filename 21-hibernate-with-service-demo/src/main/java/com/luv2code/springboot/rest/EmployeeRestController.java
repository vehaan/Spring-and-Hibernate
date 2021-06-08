package com.luv2code.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.dao.EmployeeDAO;
import com.luv2code.springboot.entity.Employee;
import com.luv2code.springboot.service.EmployeeService;

@RestController
public class EmployeeRestController {

	//quick and dirty: inject employee dao
	
	//expose "/employees" and return list of employeees
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee = employeeService.findById(employeeId);
		
		if (employee == null)
			throw new RuntimeException("Employee id not found - " + employeeId);
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
				
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
				
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public Employee updateEmployee(@PathVariable int employeeId) {
				
		Employee employee = employeeService.findById(employeeId);
		if (employee == null)
			throw new RuntimeException("Employee id not found - " + employeeId);
		employeeService.deleteById(employeeId);
		return employee;
	}
	
}
