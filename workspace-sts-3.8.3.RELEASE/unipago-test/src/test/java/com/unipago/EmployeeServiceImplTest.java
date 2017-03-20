package com.unipago;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
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
import com.unipago.serivce.EmployeeService;

public class EmployeeServiceImplTest extends AbstractIntegrationTest{
	
	@Autowired
	private EmployeeService employeeServices; 

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
		//step1: save new employee in db.
		Employee employee = new Employee();
		employee.setName("TestEmployee");	
		employeeServices.saveEmployee(employee);
		//step2: query in db
		List<Employee> employeeResult = employeeServices.findByName("TestEmployee");
		//step3: check this object exist in db
		assertThat(employeeResult.get(0).getId(), is(notNullValue()));
		
		//step3: delete this entity from db.
		employeeServices.deleteEmployee(employee.getId());

		//step4: check that object does not exist in db
		employeeResult = employeeServices.findByName("TestEmployee");
		assertThat(employeeResult.size(), is(0));
	}
}