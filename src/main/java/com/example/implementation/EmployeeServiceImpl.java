package com.example.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();

	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
		
	}


	@Override
	public void updateEmployee(Employee e,int id) {
		// TODO Auto-generated method stub
		e.setEmpId(id);
	  this.employeeRepository.save(e);
		
	}
   
}
