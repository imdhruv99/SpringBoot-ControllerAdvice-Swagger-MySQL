package com.employee.exceptionhandling.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import com.employee.exceptionhandling.model.Employee;


public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findEmployeeByEmail(String email);
	
	void deleteById(Long id);
	
	ResponseEntity<Object> updateEmployee(Employee employee, Long id);
	
	ResponseEntity<Object> creatEmployee(Employee employee);
}
