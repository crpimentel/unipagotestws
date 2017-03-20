package com.unipago;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.unipago.model.Department;
import com.unipago.model.Employee;
import com.unipago.repo.DepartmentRepository;
import com.unipago.repo.EmployeeRepository;
import com.unipago.serivce.DepartmentService;
import com.unipago.serivce.EmployeeService;

public class DeparmentServiceImplTest extends AbstractIntegrationTest{
	
	@Autowired
	private EmployeeService employeeServices; 

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DepartmentRepository departmentRep;
	
	@Autowired
	private EmployeeRepository employeeRep;
	
	@Before
	public void insertSomeDataInDb(){
		
		Department dep1 = new Department("Desarrollo de Software", "Perez", null, "Orgin");
		Department dep2 = new Department("Auditoria", "Antonio", null, "Marcos");
		Department dep3 = new Department("Finzanzas", "Damira", null, "Claudia");
		
		departmentRep.save(dep1);
		departmentRep.save(dep2);
		departmentRep.save(dep3);
		
		Department softwareDep = departmentRep.findByNameContainingIgnoreCase("Desarrollo de Software");
		Employee emp1 = new Employee("Cristian","Pimentel","Masculino",new Date(2020, 9, 17),"","","9999999999",200000,softwareDep);
		Employee emp2 = new Employee("Tabare","Pimentel","Masculino",new Date(2020, 9, 17),"","","9999999999",200000,softwareDep);
		Employee emp3 = new Employee("Yaqueline","Pimentel","Masculino",new Date(2020, 9, 17),"","","9999999999",200000,softwareDep);
		
		employeeRep.save(emp1);
		employeeRep.save(emp2);
		employeeRep.save(emp3);
	}	
	
	@After
	public void deleteData(){				
		employeeRep.deleteAll();
		departmentRep.deleteAll();		
	}
	
	@Test
	public void testAll() {
		//step1: save new department in db.
		Department department = new Department();
		department.setName("TestDepartment");	
		departmentService.saveDepartment(department);
		//step2: query in db
		Department departmentResult = departmentService.findByName("TestDepartment");
		//step3: check this object exist in db
		assertThat(departmentResult.getId(), is(notNullValue()));
		
		//step3: delete this entity from db.
		departmentService.deleteDepartment(department.getId());

		//step4: check that object does not exist in db
		departmentResult = departmentService.findByName("TestDepartment");
		assertThat(departmentResult, is(nullValue()));
	}
	
	@Test
	public void findDepartmentAll_Then_GetSomeData(){
		List<Department> departments = departmentRep.findAll();		

		assertTrue(departments.size()>0);
	}
}