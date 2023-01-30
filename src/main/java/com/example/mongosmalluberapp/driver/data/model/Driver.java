package com.example.mongosmalluberapp.driver.data.model;

import com.example.mongosmalluberapp.account.data.model.UberAccount;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Driver {
    private LocalDateTime pickUpTime = LocalDateTime.now();
@DBRef
@NonNull
private UberAccount account;
@NonNull
private String licenseNumber;
@NonNull
private String driverLocation;
private long earning;
private boolean rideStatus;
private int totalRide;
private DriverStatus driverStatus = DriverStatus.NOT_AVAILABLE;
private DriverDecision driverDecision;
private String rideDetails;
private String id;

}
