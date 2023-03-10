package com.example.mongosmalluberapp.driver.service;

import com.example.mongosmalluberapp.driver.data.model.Driver;
import com.example.mongosmalluberapp.driver.data.model.DriverDecision;
import com.example.mongosmalluberapp.driver.dto.request.DriversRequest;
import com.example.mongosmalluberapp.driver.dto.response.DriverResponce;
import com.example.mongosmalluberapp.driver.exeption.DriverException;
import com.example.mongosmalluberapp.ride.dto.request.RideRequest;

public interface DriverInterface {
    DriverResponce createDriverAccount(DriversRequest driversRequest) throws DriverException;
    int countAvailableDriver();

    DriverResponce deleteAllDriver();


    Driver findByIdentifier(String identifier);


    Driver findByDriverLocation(String ikeja);



    DriverDecision startRide();

    DriverDecision stopRide();

    DriverDecision declineRide();
}
