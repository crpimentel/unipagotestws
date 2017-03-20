package com.unipago.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unipago.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {
	Department findByNameContainingIgnoreCase(String name);
	List<Department> findByVicePresidentContainingIgnoreCase(String vicePresident);
	Department findByNameContainingIgnoreCaseAndVicePresidentContainingIgnoreCase(String name,String vicePresident);
	List<Department> findAll();
}
