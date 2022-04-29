package com.example.entity; 

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employee")
public class Employee{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	private String empName;

	 
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "eId",referencedColumnName = "empId")
		private List<Address> addresses;
	
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Employee() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empName, List<Address> addresses) {
		//super();
		this.empName = empName;
		this.addresses = addresses;
	}
	
	
}