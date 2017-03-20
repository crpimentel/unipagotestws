package com.unipago.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;

@Entity(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="nameResponsible")
	private String nameResponsible;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, 
	           mappedBy = "department")	
	private List<Employee> employees;

	private String vicePresident;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String name, String nameResponsible, List<Employee> employees, String vicePresident) {
		super();
		this.name = name;
		this.nameResponsible = nameResponsible;
		this.employees = employees;
		this.vicePresident = vicePresident;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getNameResponsible() {
		return nameResponsible;
	}

	public void setNameResponsible(String nameResponsible) {
		this.nameResponsible = nameResponsible;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public String getVicePresident() {
		return vicePresident;
	}

	public void setVicePresident(String vicePresident) {
		this.vicePresident = vicePresident;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((nameResponsible == null) ? 0 : nameResponsible.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (nameResponsible == null) {
			if (other.nameResponsible != null)
				return false;
		} else if (!nameResponsible.equals(other.nameResponsible))
			return false;
		return true;
	}
}
