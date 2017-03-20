package com.unipago.serivce;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unipago.model.Employee;
import com.unipago.repo.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void saveEmployee(Employee employee){
		employeeRepository.save(employee);
	}
	public List<Employee> findAllEmployee(){
		return (List<Employee>) employeeRepository.findAll();
	}
	
	public Employee findByNameAndLastName(String name, String lastname) {
		return employeeRepository.findByNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(name, lastname);
	}
	
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.findByNameContainingIgnoreCase(name);
	}
	
	public List<Employee> findByLastName(String lastname) {
		// TODO Auto-generated method stub
		return employeeRepository.findByLastNameContainingIgnoreCase(lastname);
	}
	
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.delete(id);
	}
	
	public Employee findEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(id);
		
	}
	
	
	
}
