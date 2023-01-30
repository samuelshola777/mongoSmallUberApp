package com.example.mongosmalluberapp.customer.service;

import com.example.mongosmalluberapp.customer.data.model.RideType;
import com.example.mongosmalluberapp.customer.dto.request.CustomerRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceTest {
@Autowired
CustomerInterface customerInterface;
CustomerRequest customerRequest1;
CustomerRequest customerRequest2;
CustomerRequest customerRequest3;
CustomerRequest customerRequest4;
    @BeforeEach
    void setUp() {
        customerRequest1 = new CustomerRequest();
        customerRequest1.setRideType(RideType.COMMERCIAL);
        customerRequest1.setEmail("chirock@Gmail.com");
        customerRequest1.setPickUpLocation("sabo");
        customerRequest1.setDropLocation("bariga");

        customerRequest2 = new CustomerRequest();
        customerRequest2.setRideType(RideType.EMERGENCY);
        customerRequest2.setEmail("wunmi@Gmail.com");
        customerRequest2.setPickUpLocation("ketu");
        customerRequest2.setDropLocation("oshodi");

        customerRequest3 = new CustomerRequest();
        customerRequest3.setRideType(RideType.CHATTER);
        customerRequest3.setEmail("toyin@Gmail.com");
        customerRequest3.setPickUpLocation("island");
        customerRequest3.setDropLocation("iganmu");

        customerRequest4 = new CustomerRequest();
        customerRequest4.setRideType(RideType.COMMERCIAL);
        customerRequest4.setEmail("jonathan@Gmail.com");
        customerRequest4.setPickUpLocation("oyinbo");
        customerRequest4.setDropLocation("surulere");

    }

//    @AfterEach
//    @Test
//    void tearDown() {
//        customerInterface.deleteAllCustomer();
//    }

@Test
    void testThatWeCanCreateUberCustomer(){
        customerInterface.createCustomer(customerRequest2);
        assertEquals(1,customerInterface.countCustomer());
}
   @Test
    void testThatWeCanFIndCustomerByEmail(){
    customerInterface.createCustomer(customerRequest2);
    customerInterface.createCustomer(customerRequest1);
    customerInterface.createCustomer(customerRequest3);
    customerInterface.createCustomer(customerRequest4);
       assertEquals(4,customerInterface.countCustomer());

       assertEquals("island",customerInterface.findCutomerByEmail("toyin@Gmail.com").getDropLocation());
   }

}