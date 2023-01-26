package com.example.mongosmalluberapp.account.controller;

import com.example.mongosmalluberapp.account.accountrExeption.LoginExeption;
import com.example.mongosmalluberapp.account.data.model.UberAccount;
import com.example.mongosmalluberapp.account.dto.request.CreateAccountRequest;
import com.example.mongosmalluberapp.account.dto.request.LoginRequest;
import com.example.mongosmalluberapp.account.dto.response.CreateAccountResponce;
import com.example.mongosmalluberapp.account.dto.response.LoginResponse;
import com.example.mongosmalluberapp.account.service.UberAccountSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/API/ACCOUNT")
@RestController
public class UberAccountController {
    @Autowired
    UberAccountSerivice uberAccountSerivice;
@PostMapping("/createAccount")
    public ResponseEntity<?> createUberAccount(CreateAccountRequest createAccountRequest){
     CreateAccountResponce createAccountResponse =   uberAccountSerivice.createUberAccount(createAccountRequest);
        return new ResponseEntity<>(createAccountResponse, HttpStatus.CREATED);

    }

@GetMapping("/countAccount")
    public long countExistingAccount(){
        return uberAccountSerivice.countExistingAccount();
    }
@GetMapping("/countLoggedInAccount")
    public int countLoggedInAccount(){
        return uberAccountSerivice.countLoggedInAccount();
    }
@DeleteMapping("/deletingCreatedAccount")
    public CreateAccountResponce deleteAllUberAccount(){
        uberAccountSerivice.deleteAllUberAccount();
        return new CreateAccountResponce("All account deleted successfully");
    }

@DeleteMapping("/DeleteAccountByIdentifier")
    public String deleteByIdentifier(String horse){
        uberAccountSerivice.findByIdentifier(horse);
        return "account deleted successfully";
    }
    @PostMapping("/findAccountByIdentifier")
   public UberAccount findUbberAccountByIdentifier(String horse){
       return uberAccountSerivice.findByIdentifier(horse);
}
@PostMapping("/changeFirstName")
    public CreateAccountResponce changeFirstName(String identifier, String changeName){
        uberAccountSerivice.changeFirstName(identifier,changeName);
        return new CreateAccountResponce("first name changed successfully");
    }
    @PostMapping("/changelastName")
    public CreateAccountResponce changeLastName(String identifier, String changeName) {
        uberAccountSerivice.changeLastName(identifier,changeName);
        return new CreateAccountResponce("last name changed successfully");
    }
    @PostMapping("/changePassword")
    public CreateAccountResponce changePassword(String identifier, String aneeka) {
        uberAccountSerivice.changePassword(identifier, aneeka);
        return new CreateAccountResponce("password changed successfully");
    }
    @PostMapping("/changeContactNumber")

    public CreateAccountResponce changeContactNumber(String identifier, String nuwNumber) {
        uberAccountSerivice.changeContactNumber(identifier,nuwNumber);
        return new CreateAccountResponce("phone number changed successfully");
    }
    @PostMapping("/Login")
    public LoginResponse loginToUberAccount(LoginRequest loginRequest1) throws LoginExeption {
      uberAccountSerivice.loginToUberAccount(loginRequest1);
        return new LoginResponse("login not successful");
    }
@GetMapping("/viewAllUberAccount")
    public List<UberAccount> viewAllUberAccount(){
        return uberAccountSerivice.viewAllUberAccount();
    }

}
