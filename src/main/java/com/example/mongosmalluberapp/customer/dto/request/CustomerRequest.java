package com.example.mongosmalluberapp.customer.dto.request;

import com.example.mongosmalluberapp.customer.data.model.RideType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String pickUpLocation;
    @NotBlank
    private String dropLocation;
    @NotBlank
//    private enum CustomerType{EMERGENCY, COMMERCIAL, CHATTER}
    private RideType rideType;


}
