package com.example.mongosmalluberapp.account.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@RequiredArgsConstructor
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

}
