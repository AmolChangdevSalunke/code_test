package com.code.test.employee.tax.deduction.Employee_Tax.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	private String code;
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}

	private String firstName;
    private String lastName;
    private double Salary;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private LocalDate   DateOfJoining;
	public LocalDate getDateOfJoining() {
		return DateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}
	@Override
	public String toString() {
		return "Employee [code=" + code + ", firstName=" + firstName + ", lastName=" + lastName + ", Salary=" + Salary
				+ ", DateOfJoining=" + DateOfJoining + "]";
	}
	
   

}
