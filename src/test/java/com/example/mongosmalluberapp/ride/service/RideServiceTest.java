package com.example.mongosmalluberapp.ride.service;

import com.example.mongosmalluberapp.customer.data.model.Customer;
import com.example.mongosmalluberapp.customer.data.model.RideType;
import com.example.mongosmalluberapp.customer.service.CustomerInterface;
import com.example.mongosmalluberapp.driver.service.DriverInterface;
import com.example.mongosmalluberapp.ride.data.model.Ride;
import com.example.mongosmalluberapp.ride.dto.request.RideRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RideServiceTest {
    @Autowired
    RideInterface rideInterface;

    RideRequest rideRequest;
    RideRequest rideRequest2;
    RideRequest rideRequest3;
    RideRequest rideRequest4;
    @BeforeEach
    void setUp() {
      rideRequest = new RideRequest();
      rideRequest.setRideType(RideType.COMMERCIAL);
      rideRequest.setCustomerEmail("chirock@Gmail.com");
      rideRequest.setPickUpLocation("yaba");
      rideRequest.setDropLocation("bariga");

      rideRequest2 = new RideRequest();
      rideRequest2.setRideType(RideType.EMERGENCY);
      rideRequest2.setCustomerEmail("wunmi@Gmail.com");
      rideRequest2.setPickUpLocation("ketu");
      rideRequest2.setDropLocation("oshodi");

      rideRequest3 = new RideRequest();
      rideRequest3.setRideType(RideType.CHATTER);
      rideRequest3.setCustomerEmail("toyin@Gmail.com");
      rideRequest3.setPickUpLocation("island");
      rideRequest3.setDropLocation("iganmu");

      rideRequest4 = new RideRequest();
      rideRequest4.setRideType(RideType.COMMERCIAL);
      rideRequest4.setCustomerEmail("jonathan@Gmail.com");
      rideRequest4.setPickUpLocation("oyinbo");
      rideRequest4.setDropLocation("surulere");


    }

    @AfterEach
    @Test
    void tearDown() {
        rideInterface.deleteAllRide();
    }
    @Test
    void oderRide(){
        rideInterface.orderRide(rideRequest);

        assertEquals(1,rideInterface.countRideOrder());
    }
    @Test
    void testThatWeCanFindRideByPickUpLocation(){

    }


}