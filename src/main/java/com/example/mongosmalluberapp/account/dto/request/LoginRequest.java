package com.example.mongosmalluberapp.account.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private String identifier;
}
