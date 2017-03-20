package com.unipago.dto;

public class DepartmentDTO {
	private Long Id;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String nameResponsible;
	private String VicePresident;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNameResponsible() {
		return nameResponsible;
	}
	public void setNameResponsible(String nameResponsible) {
		this.nameResponsible = nameResponsible;
	}
	public String getVicePresident() {
		return VicePresident;
	}
	public void setVicePresident(String vicePresident) {
		VicePresident = vicePresident;
	}
	
	}
