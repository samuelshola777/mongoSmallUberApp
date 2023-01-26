package com.example.mongosmalluberapp.account.service;

import com.example.mongosmalluberapp.account.accountrExeption.LoginExeption;
import com.example.mongosmalluberapp.account.data.model.UberAccount;
import com.example.mongosmalluberapp.account.data.repository.AccountRepository;
import com.example.mongosmalluberapp.account.dto.request.CreateAccountRequest;
import com.example.mongosmalluberapp.account.dto.request.LoginRequest;
import com.example.mongosmalluberapp.account.dto.response.CreateAccountResponce;
import com.example.mongosmalluberapp.account.dto.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UberAccountServiceImpl implements UberAccountSerivice {
    @Autowired
    AccountRepository accountRepository;

    static boolean isOnline = false;
    static int loggedInAccount;

    @Override
    public CreateAccountResponce createUberAccount(CreateAccountRequest createAccountRequest) {
        UberAccount account = uberAccountMapper(createAccountRequest);
        accountRepository.save(account);
        return new CreateAccountResponce("Uber account created successfully ");
    }

    public UberAccount uberAccountMapper(CreateAccountRequest createAccountRequest) {
        UberAccount uberAccount = new UberAccount(
                createAccountRequest.getFirstName()
                , createAccountRequest.getLastName(),
                createAccountRequest.getUserEmail()
                , createAccountRequest.getContactNumber(),
                createAccountRequest.getIdentifier(),
                createAccountRequest.getPassword());
        return uberAccount;
    }

    public long countExistingAccount() {
        return accountRepository.count();
    }
    public int countLoggedInAccount(){
        return loggedInAccount;
    }


    @Override
    public CreateAccountResponce deleteAllUberAccount() {
        accountRepository.deleteAll();
        return new CreateAccountResponce("all uber Account delete");
    }

    @Override
    public void deleteByIdentifier(String horse) {
        accountRepository.deleteAllByIdentifier(horse);
    }

    @Override
    public UberAccount findByIdentifier(String horse) {
        return accountRepository.findByIdentifier(horse);
    }

    @Override
    public CreateAccountResponce changeFirstName(String identifier, String changeName) {
        UberAccount foundAccount = findByIdentifier(identifier);
        foundAccount.setFirstName(changeName);
        accountRepository.save(foundAccount);
        return new CreateAccountResponce("first name changed successfully");
    }
        @Override
    public CreateAccountResponce changeLastName(String identifier, String changeName) {
        UberAccount foundAccount = findByIdentifier(identifier);
        foundAccount.setLastName(changeName);
        accountRepository.save(foundAccount);
        return new CreateAccountResponce("last name changed successfully");
    }

    @Override
    public CreateAccountResponce changePassword(String identifier, String aneeka) {
        UberAccount foundAccount = findByIdentifier(identifier);
        foundAccount.setPassword(aneeka);
        accountRepository.save(foundAccount);
        return new CreateAccountResponce("password changed successfully");
    }

    @Override
    public CreateAccountResponce changeContactNumber(String identifier, String nuwNumber) {
     UberAccount foundAccount = findByIdentifier(identifier);
     foundAccount.setContactNumber(nuwNumber);
     accountRepository.save(foundAccount);
        return new CreateAccountResponce("phone number changed successfully");
    }

    @Override
    public LoginResponse loginToUberAccount(LoginRequest loginRequest1) throws LoginExeption {
    UberAccount   account  = accountRepository.findByIdentifier(loginRequest1.getIdentifier());
 UberAccount verifiedAccount =  loginValidation(loginRequest1, account);
 if (verifiedAccount != null ){
     loggedInAccount++;
      isOnline = true;
 }
        return new LoginResponse("login not successful");
    }
    public UberAccount loginValidation(LoginRequest loginRequest1, UberAccount account) throws LoginExeption {

        if (account == null){
            throw new LoginExeption("Account Does nt Exist");
        }

        if (! account.getPassword().equals(loginRequest1.getPassword())){
            throw new LoginExeption("Incorrect Password".toUpperCase());
        }
        if (! account.getUserEmail().equals(loginRequest1.getEmail())){
            throw new LoginExeption("the name entered does not match the account firstName".toUpperCase());
        }
        return account;
    }

    public boolean getIfOnline(){
        return isOnline;
    }
    public List <UberAccount> viewAllUberAccount(){
        return accountRepository.findAll();
    }
}

