package com.employee.exceptionhandling.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exceptionhandling.model.Employee;
import com.employee.exceptionhandling.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Employee Management System with Example of Controller Advice and Swagger")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "View a list of available employees", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/employee")
	public List<Employee> retriveAllEmployee() {
		return employeeService.findAll();
	}

	@ApiOperation(value = "Get an employee by Email Address.")
	@GetMapping("/employee/{email}")
	Employee retriveEmployeeByEmail(
			@ApiParam(value = "Employee Email from which employee object will retrieve", required = true) @PathVariable(value = "email") String email) {
		return employeeService.findEmployeeByEmail(email);
	}

	@ApiOperation(value = "Delete an employee")
	@DeleteMapping("/employee/{id}")
	public void deleteEmployeeById(
			@ApiParam(value = "Employee Id from which employee object will delete from database table", required = true) @PathVariable(value = "id") Long id) {
		employeeService.deleteById(id);
	}

	@ApiOperation(value = "Add an employee")
	@PostMapping("/employee")
	public ResponseEntity<Object> createEmployee(
			@ApiParam(value = "Employee object store in database table", required = true) @Valid @RequestBody Employee employee) {
		
		 employeeService.creatEmployee(employee);
		 return new ResponseEntity<Object>("Data Inserted", HttpStatus.OK);
	}

	@ApiOperation(value = "Update an employee")
	@PutMapping("/employee/{id}")
	public ResponseEntity<Object> updateStudent(
			@ApiParam(value = "Update employee object", required = true) @Valid @RequestBody Employee employee,
			@ApiParam(value = "Employee Id to update employee object", required = true) @PathVariable(value = "id") long id) {
		return employeeService.updateEmployee(employee, id);
	}
}
