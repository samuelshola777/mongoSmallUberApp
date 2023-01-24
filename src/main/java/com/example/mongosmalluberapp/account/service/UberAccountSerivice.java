package com.example.mongosmalluberapp.account.service;

import com.example.mongosmalluberapp.account.accountrExeption.LoginExeption;
import com.example.mongosmalluberapp.account.data.model.UberAccount;
import com.example.mongosmalluberapp.account.dto.request.CreateAccountRequest;
import com.example.mongosmalluberapp.account.dto.request.LoginRequest;
import com.example.mongosmalluberapp.account.dto.response.CreateAccountResponce;
import com.example.mongosmalluberapp.account.dto.response.LoginResponse;

public interface UberAccountSerivice {
    CreateAccountResponce createUberAccount(CreateAccountRequest createAccountRequest);

    long countExistingAccount();

    CreateAccountResponce deleteAllUberAccount();


    void deleteByIdentifier(String horse);

    UberAccount findByIdentifier(String horse);

    CreateAccountResponce changeFirstName(String identifier, String changeName);

    CreateAccountResponce changeLastName(String horse, String sonOfGod);

    CreateAccountResponce changePassword(String ship, String aneeka);

    CreateAccountResponce changeContactNumber(String identifier, String nuwNumber);


    LoginResponse loginToUberAccount(LoginRequest loginRequest1) throws LoginExeption;
   int countLoggedInAccount();

}
