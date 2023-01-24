package com.example.mongosmalluberapp.account.controller;

import com.example.mongosmalluberapp.account.dto.request.CreateAccountRequest;
import com.example.mongosmalluberapp.account.dto.response.CreateAccountResponce;
import com.example.mongosmalluberapp.account.service.UberAccountSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UberAccount {
    @Autowired
    UberAccountSerivice uberAccountSerivice;

    public CreateAccountResponce createUberAccount(CreateAccountRequest createAccountRequest){
        uberAccountSerivice.createUberAccount(createAccountRequest);
        return new CreateAccountResponce("Account created successfully");
    }

    public long countExistingAccount(){
        return uberAccountSerivice.countExistingAccount();
    }

    public int countLoggedInAccount(){
        return uberAccountSerivice.countLoggedInAccount();
    }

    public CreateAccountResponce deleteAllUberAccount(){
        uberAccountSerivice.deleteAllUberAccount();
        return new CreateAccountResponce("All account deleted successfully");
    }

    public void deleteByIdentifier(String horse){
        uberAccountSerivice.findByIdentifier(horse);
    }




    }
