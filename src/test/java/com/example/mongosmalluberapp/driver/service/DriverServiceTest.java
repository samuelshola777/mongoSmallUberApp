package com.example.mongosmalluberapp.driver.service;

import com.example.mongosmalluberapp.account.data.model.UberAccount;
import com.example.mongosmalluberapp.account.service.UberAccountSerivice;
import com.example.mongosmalluberapp.customer.data.model.RideType;
import com.example.mongosmalluberapp.driver.data.model.DriverDecision;
import com.example.mongosmalluberapp.driver.dto.request.DriversRequest;
import com.example.mongosmalluberapp.driver.exeption.DriverException;
import com.example.mongosmalluberapp.ride.dto.request.RideRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class DriverServiceTest {
@Autowired
DriverInterface driverInterface;


DriversRequest driversRequest;
DriversRequest driversRequest2;
DriversRequest driversRequest3;
DriversRequest driversRequest4;
RideRequest rideRequest;
    @BeforeEach
    void setUp() {
        rideRequest = new RideRequest();
        rideRequest.setRideType(RideType.COMMERCIAL);
        rideRequest.setCustomerEmail("toyin@Gmail.com");
        rideRequest.setPickUpLocation("igando");
        rideRequest.setDropLocation("island");


        driversRequest = new DriversRequest();
driversRequest.setLicenseNumber("99220202hd");
driversRequest.setIdentifier("goat");
driversRequest.setDriverLocation("ijesha");
driversRequest.setDriverDecision(DriverDecision.ACCEPT_RIDE);


driversRequest2 = new DriversRequest();
driversRequest2.setIdentifier("horse");
driversRequest2.setLicenseNumber("8493845321hd2");
driversRequest2.setDriverLocation("igando");
driversRequest2.setDriverDecision(DriverDecision.ACCEPT_RIDE);

driversRequest3 = new DriversRequest();
driversRequest3.setIdentifier("ship");
driversRequest3.setLicenseNumber("842u292u3i229");
driversRequest3.setDriverLocation("ikeja");
driversRequest3.setDriverDecision(DriverDecision.DECLINE_RIDE);

driversRequest4 = new DriversRequest();
driversRequest4.setIdentifier("cow");
driversRequest4.setLicenseNumber("8432jbefjb8383");
driversRequest4.setDriverLocation("yaba");
driversRequest4.setDriverDecision(DriverDecision.ACCEPT_RIDE);
    }

//    @AfterEach
//    void tearDown() {
//        driverInterface.deleteAllDriver();
//    }
    @Test
    void testThatDriverCanCreateDriverAccountAfterLogin() throws DriverException {

        driverInterface.createDriverAccount(driversRequest2);
assertEquals(1, driverInterface.countAvailableDriver());

    }
    @Test
    void testThatDriverCanBeFIndByIdentifier() throws DriverException {
        driverInterface.createDriverAccount(driversRequest);
        driverInterface.createDriverAccount(driversRequest2);
        driverInterface.createDriverAccount(driversRequest3);
        driverInterface.createDriverAccount(driversRequest4);

        assertEquals(4,driverInterface.countAvailableDriver() );
        assertEquals("samuel", driverInterface.findByIdentifier("goat").getAccount().getFirstName());
    }
    @Test
    void testThatWeCanDeleteAllDriverAccount(){
        driverInterface.deleteAllDriver();
        assertEquals(0, driverInterface.countAvailableDriver());
    }
    @Test
    void testThatWeCanFindDriverByLocation() throws DriverException {
        driverInterface.createDriverAccount(driversRequest);
        driverInterface.createDriverAccount(driversRequest2);
        driverInterface.createDriverAccount(driversRequest3);
        driverInterface.createDriverAccount(driversRequest4);

        assertEquals("ayo", driverInterface.findByDriverLocation("ikeja").getAccount().getFirstName());
    }


}