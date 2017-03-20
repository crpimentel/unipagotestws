package com.unipago.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unipago.dto.DepartmentDTO;

import com.unipago.model.Department;

import com.unipago.serivce.DepartmentService;




@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value= "/save", method={RequestMethod.POST})
	public @ResponseBody Boolean save(@RequestBody DepartmentDTO departmentDTO)
	{
		Boolean result=false;
		Department department = new Department();
		
		department.setName(departmentDTO.getName());
		department.setNameResponsible(departmentDTO.getNameResponsible());
		department.setVicePresident(departmentDTO.getVicePresident());				
		departmentService.saveDepartment(department);
		result=true;
		return result; 
	}
	@RequestMapping(value= "/findAll",method={RequestMethod.GET})
	public @ResponseBody List<Department> findAll()
	{				
		return this.departmentService.findAllDepartment();	
	}
	@RequestMapping(value= "/findWithNameVicePresident",params={"name","vicePresident"},  method={RequestMethod.GET})
	public @ResponseBody Department findWithNameVicePresident(String name, String vicePresident)
	{				
		return this.departmentService.findByNameAndVicePresident(name, vicePresident);	
	}
	@RequestMapping(value= "/findByName",params={"name"},  method={RequestMethod.GET})
	public @ResponseBody Department findByName(String name)
	{				
		return this.departmentService.findByName(name);	
	}
	@RequestMapping(value= "/findByVicePresident",params={"vicePresident"},  method={RequestMethod.GET})
	public @ResponseBody List<Department> findByVicePresident(String vicePresident)
	{				
		return this.departmentService.findByVicePresident(vicePresident);	
	}
	@RequestMapping(value= "/testDepartmentDTO",  method={RequestMethod.GET})
	public @ResponseBody DepartmentDTO testDepartmentDTO()
	{				
		DepartmentDTO result = new DepartmentDTO();

		return result;
	}
	
	@RequestMapping(value= "/delete")
	public @ResponseBody Boolean delete(Long id)
	{
		boolean result=false;
		this.departmentService.deleteDepartment(id);
		result=true;
		return result; 
	}
	@RequestMapping(value="/update",method={RequestMethod.POST})	 
	public Boolean update(@RequestBody DepartmentDTO departmentDTO) 
	{
		Boolean result = false;
	    try {
	    	
	        Department department= departmentService.findDepartmentById(departmentDTO.getId());
	        department.setName(departmentDTO.getName());
	        department.setNameResponsible(departmentDTO.getNameResponsible()); 
	        department.setVicePresident(departmentDTO.getVicePresident());
	        
	        this.departmentService.saveDepartment(department);
	        result=true;
	    }
	    catch (Exception ex) {
	      
	    }
	    return result;
	  }


}
