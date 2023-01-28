package com.example.mongosmalluberapp.driver.dto.request;

import com.example.mongosmalluberapp.account.data.model.UberAccount;
import com.example.mongosmalluberapp.driver.data.model.Driver;
import com.example.mongosmalluberapp.driver.data.model.DriverDecision;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriversRequest {

    @NotBlank(message = "Identifier is required")
    private String identifier;

    @NotBlank(message = "License number is required")
    private String licenseNumber;
    @DBRef
    @NotBlank
    private UberAccount account;
    @NotBlank
    private String driverLocation;
    private DriverDecision driverDecision;


}
