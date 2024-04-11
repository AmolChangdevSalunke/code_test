package com.code.test.employee.tax.deduction.Employee_Tax.controller.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.test.employee.tax.deduction.Employee_Tax.controller.repo.Employeerepo;
import com.code.test.employee.tax.deduction.Employee_Tax.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	Employeerepo employeerepo;

	public String createEmployee(Employee employee) {
		Employee save = employeerepo.save(employee);
		return "Employee Saved";
	}
	
	public Employee getemployee(String code) {
		Optional<Employee> id = employeerepo.findById(code);
		if(id.isPresent()) {
		return id.get();
		}else {
		return null;
	}
	
	}

}
