package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.implementation.EmployeeServiceImpl;
@RestController
@RequestMapping("/api")
public class EmployeeController {
   @Autowired
   EmployeeServiceImpl employeeService;
   @GetMapping("/employees")
   public ResponseEntity<List<Employee>> getAllEmployees(){
	   List<Employee> list= employeeService.getAllEmployees();

       return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
   }

   @GetMapping("/employee/{id}")
   public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
	   Employee entity= employeeService.getEmployeeById(id);
	   return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
   }
   @DeleteMapping("/employee/{id}")
   public HttpStatus  deleteEmployee(@PathVariable int id){
	     this.employeeService.deleteEmployee(id);
		return HttpStatus.FORBIDDEN;
		
	   }
   @PostMapping("/employees")
   public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
	  Employee updated= employeeService.saveEmployee(employee);
	return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
   }
   @PutMapping("/employee/{id}")
   public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable int id)
   {
	   employeeService.updateEmployee(employee, id);
	   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
}