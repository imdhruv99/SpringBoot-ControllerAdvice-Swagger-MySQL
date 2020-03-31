package com.employee.exceptionhandling.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tbl_employee")
@ApiModel(description = "All details about the Employee.")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(notes = "The database generated employee ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(notes = "The employee first name")
	@NotEmpty(message = "{firstname.notempty}")
	@NotNull
	private String firstName;

	@ApiModelProperty(notes = "The employee last name")
	@NotEmpty(message = "{lastname.notempty}")
	@NotNull
	private String lastName;

	@ApiModelProperty(notes = "The employee email id")
	@NotEmpty(message = "{email.notempty}")
	@Email(message = "{email.notvalid}")
	@NotNull
	private String email;

	public Employee() {
		super();
	}

	public Employee(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public static void setId(Long id) {

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + email
				+ "]";
	}
}
