package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.entity.Employee;
import com.example.demo.SpringBootOperationApplication;
@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = SpringBootOperationApplication.class)

public class EmployeeRepositoryTest {
	@Autowired
	   private EmployeeRepository employeeRepository;
	
	   @Test
	   public void testFindById() {
	      Employee employee= getEmployee();	     
	      employeeRepository.save(employee);
	      Employee result = employeeRepository.findById(employee.getEmpId()).get();
	      assertEquals(1, result.getEmpId());	     
	   }
	   
	   @Test
	   public void testSave() {
	      Employee employee = getEmployee();
	      employeeRepository.save(employee);
	      Employee found = employeeRepository.findById(employee.getEmpId()).get();
	      assertEquals(employee.getEmpId(), found.getEmpId());	     
	   }
	   private Employee getEmployee() {
		// TODO Auto-generated method stub
		   Employee e=new Employee();
		   e.setEmpId(1);
		   e.setEmpName("raman");
		   //e.setAddresses(null);
		   
		return e;
	}
	   /*@Test
	   public void testFindAll() {
	      Employee employee = getEmployee();
	      employeeRepository.save(employee);
	      List<Employee> result = new ArrayList<>();
	      employeeRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(),1);	     
	   }
	@Test
	   public void testDeleteById() {
	      Employee employee = getEmployee();
	      employeeRepository.save(employee);
	      employeeRepository.deleteById(employee.getEmpId());
	      List<Employee> result = new ArrayList<>();
	      employeeRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(),0);
	      
	      
	   }
*/

	}