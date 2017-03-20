package com.unipago.dto;

import java.util.Date;

public class EmployeeDTO {

		private Long Id;
		private String name;	
		private String lastName;
		private String gender;
		private Date  dateOfBirth;
		private String address;
		private String email;
		private String phoneNumber;
		private double salary;
		private DepartmentDTO deparment;
		public DepartmentDTO getDeparment() {
			return deparment;
		}

		public void setDeparment(DepartmentDTO deparment) {
			this.deparment = deparment;
		}

		public EmployeeDTO(){
			
		}
		
		public Long getId() {
			return Id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public void setId(Long id) {
			Id = id;
		}
}
