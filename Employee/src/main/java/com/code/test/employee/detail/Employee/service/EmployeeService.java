package com.code.test.employee.detail.Employee.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.test.employee.detail.Employee.Entity.EmployeeDetails;
import com.code.test.employee.detail.Employee.repo.EmployeeRepo;
@Service
public class EmployeeService {
@Autowired
EmployeeRepo repo;
	public String createEmployee(@Valid EmployeeDetails employee) {
		@Valid
		EmployeeDetails save = repo.save(employee);
		
		return "Employee sucesfully created";
	}

}
