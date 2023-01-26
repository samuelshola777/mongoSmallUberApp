package com.example.mongosmalluberapp.driver.service;

import com.example.mongosmalluberapp.account.data.model.UberAccount;
import com.example.mongosmalluberapp.account.service.UberAccountSerivice;
import com.example.mongosmalluberapp.driver.data.model.Driver;
import com.example.mongosmalluberapp.driver.data.repository.DriverRepository;
import com.example.mongosmalluberapp.driver.dto.request.DriversRequest;
import com.example.mongosmalluberapp.driver.dto.response.DriverResponce;
import com.example.mongosmalluberapp.driver.exeption.DriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService implements DriverInterface {
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    UberAccountSerivice accountService;

    @Override
    public DriverResponce createDriverAccount(DriversRequest driversRequest) {
        UberAccount foundAccount = accountService.findByIdentifier(driversRequest.getIdentifier());
        Driver newDriver = Driver.builder()
                .licenseNumber(driversRequest.getLicenseNumber())
                .account(foundAccount).driverLocation(driversRequest.getDriverLocation())
                .build();
        driverRepository.save(newDriver);
        return new DriverResponce("driver account Create successfully".toUpperCase());
    }


    public int countAvailableDriver() {
        return (int) driverRepository.count();
    }

    @Override
    public DriverResponce deleteAllDriver() {
        driverRepository.deleteAll();
        return new DriverResponce("all driver account deleted successfully");
    }

    @Override
    public Driver findByIdentifier(String identifier) {
        UberAccount foundAccount = accountService.findByIdentifier(identifier);
        Driver foundDriver = driverRepository.findByAccount(foundAccount);
        return foundDriver;
    }

    @Override
    public Driver findByDriverLocation(String ikeja) {
        Driver foundDriver = driverRepository.findByDriverLocation(ikeja);
        return foundDriver;
    }


}
