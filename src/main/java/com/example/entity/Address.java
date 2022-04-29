package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="address")
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	private String addType;
	private String addLocation;
	

	
	@ManyToOne
	private Employee employee;
	

	public int getAddId() {
		return addId;
	}


	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getAddType() {
		return addType;
	}

	public void setAddType(String addType) {
		this.addType = addType;
	}

	public String getAddLocation() {
		return addLocation;
	}

	public void setAddLocation(String addLocation) {
		this.addLocation = addLocation;
	}	
}
