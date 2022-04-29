package com.example.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.repository.AddressRepository;
import com.example.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	   AddressRepository addressRepository;

	@Override
	public Address getAddressById(int id) {
		// TODO Auto-generated method stub
		Optional<Address> optional = addressRepository.findById(id);
		Address address = null;
		if (optional.isPresent()) {
			address = optional.get();
		} else {
			throw new RuntimeException(" Address not found for id :: " + id);
		}
		return address;
	}

	@Override
	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}

	@Override
	public Address saveAddress(Address address) {
		 return this.addressRepository.save(address);
		
	}

	@Override
	public void deleteAddress(int id) {
		// TODO Auto-generated method stub
		this.addressRepository.deleteById(id);
		
	}

	@Override
	public void updateAddress(Address a, int id) {
		// TODO Auto-generated method stub
		a.setAddId(id);
		this.addressRepository.save(a);
		
	}
 
}
