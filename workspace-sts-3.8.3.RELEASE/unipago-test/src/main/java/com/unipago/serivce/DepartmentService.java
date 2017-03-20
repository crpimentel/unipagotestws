package com.unipago.serivce;

import java.util.List;

import com.unipago.model.Department;


public interface DepartmentService {
	void saveDepartment(Department employee);
	List<Department> findAllDepartment();
	Department findByNameAndVicePresident(String name,String vicePresident);
	Department findByName(String name);
	List<Department> findByVicePresident(String lastname);
	void deleteDepartment(Long id);
	Department findDepartmentById(Long id);
}
