package com.unipago.repo;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unipago.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	List<Employee> findByNameContainingIgnoreCase(String name);
	List<Employee> findByLastNameContainingIgnoreCase(String lastname);
	Employee findByNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String name,String lastname);
}
