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
    @BeforeEach
    void setUp() {
      rideRequest = new RideRequest();
      rideRequest.setRideType(RideType.COMMERCIAL);
      rideRequest.setCustomerEmail("toyin@Gmail.com");
      rideRequest.setPickUpLocation("igando");
      rideRequest.setDropLocation("island");


    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void oderRide(){
        rideInterface.orderRide(rideRequest);

        assertEquals(1,rideInterface.countRideOrder());
    }


}