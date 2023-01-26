package com.example.mongosmalluberapp.ride.data.model;

import com.example.mongosmalluberapp.TIme;
import com.example.mongosmalluberapp.customer.data.model.Customer;
import com.example.mongosmalluberapp.driver.data.model.Driver;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

@Data
@Document
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class Ride {
    private LocalDateTime pickUpTime = LocalDateTime.now();
    private LocalDateTime dropTime = LocalDateTime.now();
    private LocalDateTime tripEstimatedTime = LocalDateTime.now();

    @NonNull
    private String identifier;
    @NonNull
    private String dropLocation;
    @NonNull
    private String pickUpLocation;
    @Id
    private String id;
    

}
