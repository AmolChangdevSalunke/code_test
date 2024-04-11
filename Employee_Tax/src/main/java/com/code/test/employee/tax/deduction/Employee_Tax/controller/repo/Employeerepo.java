package com.code.test.employee.tax.deduction.Employee_Tax.controller.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.code.test.employee.tax.deduction.Employee_Tax.entity.Employee;
@Repository
public interface Employeerepo extends CrudRepository<Employee, String>{

	Employee save(Employee employee);

}
