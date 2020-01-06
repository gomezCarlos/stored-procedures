package com.example.demosp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@Pattern(regexp="[0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[\\-]?[0-9kK]")
	private String rut;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	private String address;
	

	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	public String toString() {
		return String.format("Student: [rut=%s, name=%s %s]", rut, firstName, lastName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}
	
}
