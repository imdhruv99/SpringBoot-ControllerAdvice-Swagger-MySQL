package com.employee.exceptionhandling.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.exceptionhandling.model.Employee;
import com.employee.exceptionhandling.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee findEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

	@Override
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public ResponseEntity<Object> updateEmployee(Employee employee, Long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		
		if(!employeeOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Employee.setId(id);
		employeeRepository.save(employee);
		return ResponseEntity.accepted().body(employee);
	}

	@Override
	public ResponseEntity<Object> creatEmployee(Employee employee) {
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getId()).toUri();
		
		return ResponseEntity.created(location).build();

	}

}
