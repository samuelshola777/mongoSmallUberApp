package com.example.mongosmalluberapp.customer.data.model;

import com.example.mongosmalluberapp.ride.data.model.Ride;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Customer {
    @NonNull
    private String email;
    private LocalDateTime pickUpTime = LocalDateTime.now();
    private LocalDateTime dropOffTime = LocalDateTime.now().plusMinutes(20);
    private String dropTime;
    private long walletBalance;
    private boolean rideStatus;
    @NotBlank
    @NonNull
    private String pickUpLocation;
    @NotBlank
    @NonNull
    private String dropLocation;
    private  RideType rideType;






}
