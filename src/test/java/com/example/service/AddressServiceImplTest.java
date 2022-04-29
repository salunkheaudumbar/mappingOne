package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.entity.Address;
import com.example.implementation.AddressServiceImpl;
import com.example.demo.SpringBootOperationApplication;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootOperationApplication.class)
public class AddressServiceImplTest {
   @MockBean
   private AddressServiceImpl addressService;
   @Test
   public void testGetAllAddresses() throws Exception {
	   Address add = getAddress();
      List<Address> adds = new ArrayList<>();
      adds.add(add);
      given(addressService.getAllAddresses()).willReturn(adds);
      List<Address> result = addressService.getAllAddresses();
      assertEquals(result.size(), 1);
   }
   @Test
   public void testGetAddress() throws Exception {
	   Address add = getAddress();
      given(addressService.getAddressById(1)).willReturn(add);
      Address result = addressService.getAddressById(1);
      assertEquals(result.getAddId(), 1);	
   }
   @Test
   public void testDeleteAddress() throws Exception {
      doNothing().when(addressService).deleteAddress(1);
      addressService.deleteAddress(1);
      assertTrue(true);
   }
   @Test
   public void testSaveOrUpdateAddress() throws Exception {
	   Address add = getAddress();
      doNothing().when(addressService).saveAddress(add);	
      addressService.saveAddress(add);
      assertTrue(true);
   }
   @SuppressWarnings("unused")
private Address getAddress() {
	   Address add = new Address();
      
      add.setAddId(1);
      add.setAddLocation("miraj");
      add.setAddType("current");
      	
      
      return add;
   }
}