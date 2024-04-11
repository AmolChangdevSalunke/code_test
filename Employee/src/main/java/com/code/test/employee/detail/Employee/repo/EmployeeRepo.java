package com.code.test.employee.detail.Employee.repo;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.code.test.employee.detail.Employee.Entity.EmployeeDetails;
@Repository
public interface EmployeeRepo extends CrudRepository<EmployeeDetails, String>{

	@Valid
	EmployeeDetails save(@Valid EmployeeDetails employee);

}
