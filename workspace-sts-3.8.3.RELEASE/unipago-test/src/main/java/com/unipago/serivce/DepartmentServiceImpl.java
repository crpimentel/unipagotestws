package com.unipago.serivce;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unipago.model.Department;

import com.unipago.repo.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public void saveDepartment(Department department) {
		 departmentRepository.save(department);
		
	}
	
	public List<Department> findAllDepartment() {
		 return (List<Department>) departmentRepository.findAll();
		
	}
	
	public Department findByNameAndVicePresident(String name, String vicePresident) {
		 return departmentRepository.findByNameContainingIgnoreCaseAndVicePresidentContainingIgnoreCase(name, vicePresident);
	}

	@Override
	public Department findByName(String name) {
		return departmentRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public List<Department> findByVicePresident(String vicePresident) {
		return departmentRepository.findByVicePresidentContainingIgnoreCase(vicePresident);
	}

	@Override
	public void deleteDepartment(Long id) {
		departmentRepository.delete(id);
		
	}

	@Override
	public Department findDepartmentById(Long id) {
		// 
		return departmentRepository.findOne(id);
	}
}
