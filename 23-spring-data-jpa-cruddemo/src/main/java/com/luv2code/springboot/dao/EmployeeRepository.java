package com.luv2code.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//that's it...no need to write any code. If needed you can write
}
