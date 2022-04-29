package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Address;
@Service
public interface AddressService {
	public Address getAddressById(int id);
	   public List<Address> getAllAddresses();
	   public Address saveAddress(Address address);
	   public void deleteAddress(int id);
	   public void updateAddress(Address a,int id);
	   
	   
}
