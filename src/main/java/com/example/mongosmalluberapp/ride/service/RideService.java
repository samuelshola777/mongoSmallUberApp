package com.example.mongosmalluberapp.ride.service;

import com.example.mongosmalluberapp.driver.data.model.Driver;
import com.example.mongosmalluberapp.driver.service.DriverInterface;
import com.example.mongosmalluberapp.ride.data.model.Ride;
import com.example.mongosmalluberapp.ride.data.repository.RideRepository;
import com.example.mongosmalluberapp.ride.dto.request.RideRequest;
import com.example.mongosmalluberapp.ride.dto.responce.RideResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideService implements RideInterface {
    @Autowired
    RideRepository rideRepository;
    @Autowired
    DriverInterface driverInterface;


    @Override
    public RideResponce orderRide(RideRequest rideRequest) {
        Driver foundDriver = driverInterface.findByDriverLocation(rideRequest.getPickUpLocation());
        Ride ride = Ride.builder().driver(foundDriver).rideType(rideRequest.getRideType())
                .pickUpLocation(rideRequest.getPickUpLocation())
                .customerEmail(rideRequest.getCustomerEmail()).
                dropLocation(rideRequest.getDropLocation()).build();
        rideRepository.save(ride);
        return new RideResponce("ride ordered successfully");
    }
    

    @Override
    public int countRideOrder() {
        return (int) rideRepository.count();
    }
}
