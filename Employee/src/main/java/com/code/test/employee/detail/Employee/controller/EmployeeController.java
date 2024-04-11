package com.code.test.employee.detail.Employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.code.test.employee.detail.Employee.Entity.EmployeeDetails;
import com.code.test.employee.detail.Employee.service.EmployeeService;
@RestController

public class EmployeeController {
	@Autowired(required =true)
	EmployeeService service;

	@PostMapping("/save/employees")
	public ResponseEntity<EmployeeDetails> createEmployee(@Valid @RequestBody EmployeeDetails employee) {

		// Save the employee details
		String createEmployee = service.createEmployee(employee);
		return new ResponseEntity<EmployeeDetails>(employee, HttpStatus.CREATED);

		
	}
}
