package com.example.mongosmalluberapp.account.dto.request;

import lombok.Data;

@Data
public class AccountRequest {
    private String firstName, lastName;
    private String userEmail;
    private String contactNumber;
    private String identifier;
    private String password;

}
