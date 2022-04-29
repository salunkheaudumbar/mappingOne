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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.demo.SpringBootCrudOperationApplication;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootCrudOperationApplication.class)
@AutoConfigureMockMvc
public class AddressControllerTest {
   @Autowired
   private MockMvc mvc;
   @MockBean
   private AddressController addressController;
   @Test
   public void testGetAllAddresses() throws Exception {
	   Address address = getAddress();
      List<Address> addresses = new ArrayList<>();
      addresses.add(address);
      given(addressController.getAllAddresses()).willReturn(addresses);
      mvc.perform(get("/address/addresses/").contentType(APPLICATION_JSON)).andExpect(status().isOk())
         .andExpect(jsonPath("$[0].addId", is(address.getAddId())));
   }
   
   @Test
   public void testGetAddress() throws Exception {
	   Address address = getAddress();
      given(addressController.getAddress(1)).willReturn(address);
      mvc.perform(get("/add/" + address.getAddId()).contentType(APPLICATION_JSON)).andExpect(status().isOk())
         .andExpect(jsonPath("addId", is(address.getAddId())));
   }
   @Test
   public void testDeleteAddress() throws Exception {
	   Address address = getAddress();
      doNothing().when(addressController).deleteAddress(1);
      mvc.perform(delete("/add/" + address.getAddId()).contentType(APPLICATION_JSON))
         .andExpect(status().isOk()).andReturn();
      
   }
   @Test
   public void testAddAddress() throws Exception {
	   Address address = getAddress();
      doNothing().when(addressController).addAddress(address);
      mvc.perform(post("/address/").content(asJson(address)).contentType(APPLICATION_JSON))
         .andExpect(status().isOk()).andReturn();
   }
   @Test
   public void testUpdateAddress() throws Exception {
	   Address address = getAddress();
      doNothing().when(addressController).updateAddress(address,address.getAddId());
      mvc.perform(put("/address/$[addId]").content(asJson(address)).contentType(APPLICATION_JSON))
         .andExpect(status().isOk()).andReturn();
   }
   private Address getAddress() {
      Address address = new Address();
      address.setAddId(1);
      address.setAddLocation("Miraj");
     address.setAddType("current");
      return address;
   }
   private static String asJson(final Object obj) {
      try {
         return new ObjectMapper().writeValueAsString(obj);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
}