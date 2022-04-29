package com.example.controller;


import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.entity.Employee;
import com.example.demo.SpringBootOperationApplication;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootOperationApplication.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {
   @Autowired
   private MockMvc mvc;
   @MockBean
   private EmployeeController employeeController;
   @Test
   public void testGetAllEmployees() throws Exception {
      Employee employee = getEmployee();
      List<Employee> employees = new ArrayList<>();
      employees.add(employee);
      given(employeeController.getAllEmployees()).willReturn((ResponseEntity<List<Employee>>) employees);
      mvc.perform(get("/employee/employees/").contentType(APPLICATION_JSON)).andExpect(status().isOk())
         .andExpect(jsonPath("$[0].empId", is(employee.getEmpId())));
   }
   
   @Test
   public void testGetEmployee() throws Exception {
	   ResponseEntity<Employee> employee = getEmployee();
      given(employeeController.getEmployee(1)).willReturn( employee);
      mvc.perform(get("/employee/" + employee.getEmpId()).contentType(APPLICATION_JSON)).andExpect(status().isOk())
         .andExpect(jsonPath("empId", is(employee.getEmpId())));
   }
   @Test
   public void testDeleteEmployee() throws Exception {
      Employee employee = getEmployee();
      doNothing().when(employeeController).deleteEmployee(1);
      mvc.perform(delete("/employee/" + employee.getEmpId()).contentType(APPLICATION_JSON))
         .andExpect(status().isOk()).andReturn();
      
   }
   @Test
   public void testAddEmployee() throws Exception {
      Employee employee = getEmployee();
      doNothing().when(employeeController).addEmployee(employee);
      mvc.perform(post("/employee/").content(asJson(employee)).contentType(APPLICATION_JSON))
         .andExpect(status().isOk()).andReturn();
   }
   @Test
   public void testUpdateEmployee() throws Exception {
      Employee employee = getEmployee();
      doNothing().when(employeeController).updateEmployee(employee,employee.getEmpId());
      mvc.perform(put("/employee/$[empId]/").content(asJson(employee)).contentType(APPLICATION_JSON))
         .andExpect(status().isOk()).andReturn();
   }
   private Employee getEmployee() {
      Employee employee = new Employee();
      employee.setEmpId(1);
      employee.setEmpName("Mahesh");
     
      return employee;
   }
   private static String asJson(final Object obj) {
      try {
         return new ObjectMapper().writeValueAsString(obj);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
}