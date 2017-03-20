package com.unipago.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	
	@RequestMapping(value="/employee", method={RequestMethod.GET})
	public @ResponseBody List<String> getEmployees(){
		List<String> employees = new ArrayList<String>();
		employees.add("Smith");
		employees.add("Sarah");
		employees.add("Emi");
		employees.add("Cristal");
		return employees;		
	}
}
