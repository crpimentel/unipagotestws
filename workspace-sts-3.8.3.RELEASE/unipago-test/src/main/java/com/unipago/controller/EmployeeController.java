package com.unipago.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.unipago.dto.EmployeeDTO;
import com.unipago.model.Employee;
import com.unipago.serivce.EmployeeService;

//springrest 
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value= "/save", method={RequestMethod.POST})
	public @ResponseBody Boolean save(@RequestBody EmployeeDTO employeeDTO)
	{
		Boolean result=false;
		Employee employee = new Employee();
		
		employee.setName(employeeDTO.getName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setGender(employeeDTO.getGender());
		employee.setAddress(employeeDTO.getAddress());
		employee.setSalary(employeeDTO.getSalary());		
		employee.setPhoneNumber(employeeDTO.getPhoneNumber());
		employee.setDepartment(employee.getDepartment());
		employee.setDateOfBirth(employeeDTO.getDateOfBirth());
		employeeService.saveEmployee(employee);
		result=true;
		return result; 
	} 
	
	@RequestMapping(value= "/testsave")
	public @ResponseBody Boolean testsave()
	{
		
		Boolean result=false;
		EmployeeDTO employeeCris = new EmployeeDTO();
		employeeCris.setName("Cristian");
		employeeCris.setLastName("Pimentel");
		employeeCris.setGender("M");
		employeeCris.setEmail("cristiantabarepimentel@gmail.com");
		employeeCris.setPhoneNumber("8096953755");
		employeeCris.setSalary(70000);
		employeeCris.setAddress("Rep Dom");
		this.save(employeeCris);
		
		EmployeeDTO employee = new EmployeeDTO();
		employee.setName("Fausto");
		employee.setLastName("Pimentel");
		employee.setGender("M");
		employee.setEmail("f.pimentel@gmail.com");
		employee.setPhoneNumber("8096953755");
		employee.setSalary(60000);
		employee.setAddress("texas");
		this.save(employee);
		
		
		EmployeeDTO employee2 = new EmployeeDTO();
		employee2.setName("Crisostomo");
		employee2.setLastName("Pimentel");
		employee2.setGender("M");
		employee2.setEmail("tabarepimentel@gmail.com");
		employee2.setPhoneNumber("80996953755");
		employee2.setSalary(50000);
		employee2.setAddress("Hainamosa Calle Primera Edf 18 apto 302");
		this.save(employee2);
		
		
		EmployeeDTO employee3 = new EmployeeDTO();
		employee3.setName("Belkis");
		employee3.setLastName("Cruz");
		employee3.setGender("F");
		employee3.setEmail("belkisYaqueline@gmail.com");
		employee3.setPhoneNumber("809-697-1961");
		employee3.setSalary(50000);
		employee3.setAddress("Hainamosa Calle Primera Edf 18 apto 302");
		this.save(employee3);
		
		
		EmployeeDTO employee4 = new EmployeeDTO();
		employee4.setName("Kenia");
		employee4.setLastName("Tineo");
		employee4.setGender("F");
		employee4.setEmail("keniathebaby@gmail.com");
		employee4.setPhoneNumber("809-844-4722");
		employee4.setSalary(40000);
		employee4.setAddress("Hainamosa Calle Primera Edf 18 apto 302");
		this.save(employee4);
		
		
		EmployeeDTO employee5 = new EmployeeDTO();
		employee5.setName("Cristal");
		employee5.setLastName("Pimentel");
		employee5.setGender("M");
		employee5.setEmail("cristalpimentel@gmail.com");
		employee5.setPhoneNumber("849-943-7022");
		employee5.setSalary(70000);
		employee5.setAddress("Hainamosa Calle Primera Edf 18 apto 302");
		this.save(employee5);
		result =true;
		return result;

	}
	@RequestMapping(value= "/findAllEmployee",method={RequestMethod.GET})
	public @ResponseBody List<Employee> findAllEmployee()
	{				
		return this.employeeService.findAllEmployee();	
	}
	@RequestMapping(value= "/findEmployeeWithNameLastname",params={"name","lastname"},  method={RequestMethod.GET})
	public @ResponseBody Employee findEmployeeWithNameLastname(String name, String lastname)
	{				
		return this.employeeService.findByNameAndLastName(name, lastname);	
	}
	@RequestMapping(value= "/findByName",params={"name"},  method={RequestMethod.GET})
	public @ResponseBody List<Employee> findByName(String name)
	{				
		return this.employeeService.findByName(name);	
	}
	@RequestMapping(value= "/findByLastName",params={"lastname"},  method={RequestMethod.GET})
	public @ResponseBody List<Employee> findByLastName(String lastname)
	{				
		return this.employeeService.findByLastName(lastname);	
	}
	@RequestMapping(value= "/testEmployeeDto",  method={RequestMethod.GET})
	public @ResponseBody EmployeeDTO testEmployeeDto()
	{				
		EmployeeDTO result = new EmployeeDTO();

		return result;
	}
	
	@RequestMapping(value= "/deleteEmployee")
	public @ResponseBody Boolean deleteEmployee(Long id)
	{
		boolean result=false;
		this.employeeService.deleteEmployee(id);
		result=true;
		return result; 
	}
	@RequestMapping(value="/updateEmployee",method={RequestMethod.POST})	 
	public Boolean updateEmployee(@RequestBody EmployeeDTO employeeDTO) 
	{
		Boolean result = false;
	    try {
	    	
	        Employee employee = employeeService.findEmployeeById(employeeDTO.getId());
	        employee.setEmail(employeeDTO.getEmail());
	        employee.setName(employeeDTO.getName()); 
	        employee.setLastName(employeeDTO.getLastName());
	        employee.setAddress(employeeDTO.getAddress());
	        employee.setGender(employeeDTO.getGender());
	        employee.setSalary(employeeDTO.getSalary());
	        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
	        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
	        this.employeeService.saveEmployee(employee);
	        result=true;
	    }
	    catch (Exception ex) {
	      
	    }
	    return result;
	  }
	
	
}
