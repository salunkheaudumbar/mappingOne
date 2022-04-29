package com.example.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.demo.SpringBootOperationApplication;
import com.example.entity.Address;
@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = SpringBootOperationApplication.class)

public class AddressRepositoryTest {
	@Autowired
	   private AddressRepository addressRepository;
	   @Test
	   public void testFindById() {
		      Address address = getAddress();
		      addressRepository.save(address);
	      Address result = addressRepository.findById(address.getAddId()).get();
	      assertEquals(address.getAddId(), result.getAddId());	     
	   }
	   
	   @Test
	   public void testSave() {
		      Address address = getAddress();
		      addressRepository.save(address);
	      Address found = addressRepository.findById(address.getAddId()).get();
	      assertEquals(address.getAddId(), found.getAddId());	     
	   }
	   /*@Test
	   public void testFindAll() {
		      Address address = getAddress();
		      addressRepository.save(address);
	      List<Address> result = new ArrayList<>();
	      addressRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(), 1);	     
	   }
	   @Test
	   public void testDeleteById() {
	      Address address = getAddress();
	      addressRepository.save(address);
	      addressRepository.deleteById(address.getAddId());
	      List<Address> result = new ArrayList<>();
	      addressRepository.findAll().forEach(a -> result.add(a));
	      assertEquals(result.size(), 0);
	   }
	   */
	private Address getAddress() {
		// TODO Auto-generated method stub
		Address adds=new Address();
		adds.setAddId(1);
		adds.setAddLocation("Miraj");
		adds.setAddType("cuurent");
		return adds;
	}
	   
}
