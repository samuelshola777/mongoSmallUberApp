package com.example.mongosmalluberapp.ride.service;

import com.example.mongosmalluberapp.driver.data.model.Driver;
import com.example.mongosmalluberapp.ride.dto.request.RideRequest;
import com.example.mongosmalluberapp.ride.dto.responce.RideResponce;

public interface RideInterface {




    RideResponce orderRide(RideRequest rideRequest);

    int countRideOrder();
}
