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

import com.example.entity.Address;
import com.example.implementation.AddressServiceImpl;

@RestController
@RequestMapping("/api")
public class AddressController {
   @Autowired
   AddressServiceImpl addressService;
   @GetMapping("/addresses")
   public ResponseEntity<List<Address>> getAllAddresses(){
	   List<Address> list=addressService.getAllAddresses();
	   return new ResponseEntity<List<Address>>(list, new HttpHeaders(), HttpStatus.OK);
   }
   @GetMapping("/address/{id}")
   public ResponseEntity<Address> getAddress(@PathVariable("id") int id) {
	   Address entity=addressService.getAddressById(id);
	   return new ResponseEntity<Address>(entity, new HttpHeaders(), HttpStatus.OK);
   }
   @DeleteMapping("/address/{id}")
   public HttpStatus deleteAddress(@PathVariable("id") int id) {
	   addressService.deleteAddress(id);
	   return HttpStatus.FORBIDDEN;
   }
   @PostMapping("/address")
   public ResponseEntity<Address> addAddress(@RequestBody Address address) {
	   Address updated=addressService.saveAddress(address);
	   return new ResponseEntity<Address>(updated, new HttpHeaders(), HttpStatus.OK);
   }
   @PutMapping("/address/{id}")
   public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
	   addressService.saveAddress(address);
	   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }	
}
