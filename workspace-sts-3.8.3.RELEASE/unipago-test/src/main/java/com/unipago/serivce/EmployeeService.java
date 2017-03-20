package com.unipago.serivce;

import java.util.List;

import com.unipago.model.Employee;

public interface EmployeeService {
	
	void saveEmployee(Employee employee);
	List<Employee> findAllEmployee();
	Employee findByNameAndLastName(String name,String lastname);
	List<Employee> findByName(String name);
	List<Employee> findByLastName(String lastname);
	void deleteEmployee(Long id);
	Employee findEmployeeById(Long id);

}
