package com.example.mongosmalluberapp.ride.dto.request;


import com.example.mongosmalluberapp.customer.data.model.RideType;
import com.example.mongosmalluberapp.driver.data.model.Driver;
import com.example.mongosmalluberapp.ride.data.model.RideUpdate;
import lombok.Data;
@Data
public class RideRequest {

   private String customerEmail;
   private String dropLocation;
   private String pickUpLocation;
   private  RideType rideType;
   private  boolean rideStatus;
   private Driver driver;
   private RideUpdate rideUpdate = RideUpdate.PENDING;



}
