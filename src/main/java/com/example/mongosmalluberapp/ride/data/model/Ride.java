package com.example.mongosmalluberapp.ride.data.model;

import com.example.mongosmalluberapp.customer.data.model.Customer;
import com.example.mongosmalluberapp.customer.data.model.RideType;
import com.example.mongosmalluberapp.driver.data.model.Driver;
import com.example.mongosmalluberapp.driver.service.DriverInterface;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
public class Ride {
    @Autowired
    DriverInterface driverInterface;
    private LocalDateTime pickUpTime = LocalDateTime.now();
    private LocalDateTime dropTime = LocalDateTime.now().plusSeconds(60);
    private LocalDateTime tripEstimatedTime = LocalDateTime.now().plusMinutes(10);
    private static boolean rideStatus;


    @NonNull
    private String customerEmail;
    @NonNull
    private String dropLocation;
    @NonNull
    private String pickUpLocation;
    @NonNull
    private Driver driver;
    @NonNull
    private RideType rideType;
    private static RideUpdate rideUpdate;
    private long rideAmount;
    @Id
    private String id;

    
    

}
