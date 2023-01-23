package com.example.mongosmalluberapp.account.data.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data

@Document
public class UberAccount {

    @NonNull
    private String firstName, lastName;
    @NonNull
    private String userEmail;
    @NonNull
    private String contactNumber;
    @NonNull
    private String identifier;
    @NonNull
    private String password;
@Id
private String userId;
private LocalDateTime registrationDate = LocalDateTime.now();
private boolean isOnline = false;

}
