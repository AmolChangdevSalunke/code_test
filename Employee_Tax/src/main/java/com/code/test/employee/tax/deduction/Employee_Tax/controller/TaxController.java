package com.code.test.employee.tax.deduction.Employee_Tax.controller;

import java.time.LocalDate;
import java.time.Period;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.code.test.employee.tax.deduction.Employee_Tax.controller.service.EmployeeService;
import com.code.test.employee.tax.deduction.Employee_Tax.entity.Employee;

@RestController
public class TaxController {
	@Autowired
	EmployeeService service;
	@PostMapping("/save/employees")
	public ResponseEntity<String> createEmployee (@RequestBody Employee employee) {

		// Save the employee details
		String createEmployee = service.createEmployee(employee);

		return ResponseEntity.ok("Employee details saved successfully ");
	}

	private int totalSalary;
	private double taxAmount;

	@PostMapping("/calculate/{code}")
	public ResponseEntity<Double> calculateTaxSlab(@PathVariable("code") String code) {
		Employee employee = service.getemployee(code);
		//@RequestBody Employee employee
		LocalDate dateOfJoining = employee.getDateOfJoining();
		double totalSalary = calculateTotalSalary(employee.getSalary(), dateOfJoining);
		double taxAmount = calculateTaxAmount(totalSalary);

		return ResponseEntity.ok(taxAmount);
	}

	private double calculateTotalSalary(double salary, LocalDate dateOfJoining) {
		LocalDate currentDate = LocalDate.now();

		int months = Period.between(dateOfJoining.withDayOfMonth(1), currentDate.withDayOfMonth(1)).getMonths();

		double totalSalary = salary * months;

		return totalSalary;
	}

	private double calculateTaxAmount(double totalSalary) {
		double taxAmount = 0;

		if ((totalSalary < 2500000)) {
			if (totalSalary <= 250000) {
				taxAmount = 0.0;
			} else if (totalSalary > 250000 && totalSalary <= 500000) {
				taxAmount = (totalSalary - 250000) * 0.05;
			} else if (totalSalary > 500000 && totalSalary <= 1000000) {
				taxAmount = 12500 + (totalSalary - 500000) * 0.1;
			} else {
				taxAmount = 62500 + (totalSalary - 1000000) * 0.2;
			}
			return taxAmount;
		} else {

			taxAmount = 62500 + (totalSalary - 1000000) * 0.2;
			double excessAmount = totalSalary - 2500000;
			double cess = excessAmount * 0.02;
			taxAmount += cess;

			// Implement tax slab calculation logic as per specific rules

			return taxAmount;
		}
	}
}
