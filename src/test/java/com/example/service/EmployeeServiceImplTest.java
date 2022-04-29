package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.SpringBootOperationApplication;
import com.example.entity.Employee;
import com.example.implementation.EmployeeServiceImpl;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootOperationApplication.class)
public class EmployeeServiceImplTest {
   @MockBean
   private EmployeeServiceImpl employeeService;
   @Test
   public void testGetAllEmployees() throws Exception {
      Employee employee = getEmployee();
      List<Employee> employees = new ArrayList<>();
      employees.add(employee);
      given(employeeService.getAllEmployees()).willReturn(employees);
      List<Employee> result = employeeService.getAllEmployees();
      assertEquals(result.size(), 1);
   }
   @Test
   public void testGetEmployee() throws Exception {
      Employee employee = getEmployee();
      given(employeeService.getEmployeeById(1)).willReturn(employee);
      Employee result = employeeService.getEmployeeById(1);
      assertEquals(result.getEmpId(), 1);	
   }
   @Test
   public void testDeleteEmployee() throws Exception {
      doNothing().when(employeeService).deleteEmployee(1);
      employeeService.deleteEmployee(1);
      assertTrue(true);
   }
   @Test
   public void testSaveOrUpdateEmployee() throws Exception {
      Employee employee = getEmployee();
      doNothing().when(employeeService).saveEmployee(employee);	
      employeeService.saveEmployee(employee);
      assertTrue(true);
   }
   private Employee getEmployee() {
      Employee employee = new Employee();
      employee.setEmpId(1);
      employee.setEmpName("Mahesh");
      
      return employee;
   }
}