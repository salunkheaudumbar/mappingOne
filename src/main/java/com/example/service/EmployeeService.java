package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Employee;
@Service
public interface EmployeeService {
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	 public Employee saveEmployee(Employee employee);
	 public void deleteEmployee(int id);
	public void updateEmployee(Employee e,int id);
}
