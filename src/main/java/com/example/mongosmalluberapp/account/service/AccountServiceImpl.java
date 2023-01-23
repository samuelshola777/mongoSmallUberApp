package com.example.mongosmalluberapp.account.service;

import com.example.mongosmalluberapp.account.data.model.UberAccount;
import com.example.mongosmalluberapp.account.data.repository.AccountRepository;
import com.example.mongosmalluberapp.account.dto.request.AccountRequest;
import com.example.mongosmalluberapp.account.dto.response.AccountResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountSerivice {
    @Autowired
    AccountRepository accountRepository;


    @Override
    public AccountResponce createUberAccount(AccountRequest accountRequest) {
        UberAccount account = uberAccountMapper(accountRequest);
        accountRepository.save(account);
        return new AccountResponce("Uber account created successfully ");
    }

    public UberAccount uberAccountMapper(AccountRequest accountRequest) {
        UberAccount uberAccount = new UberAccount(
                accountRequest.getFirstName()
                , accountRequest.getLastName(),
                accountRequest.getUserEmail()
                , accountRequest.getContactNumber(),
                accountRequest.getIdentifier(),
                accountRequest.getPassword());
        return uberAccount;
    }

    public long countAccount() {
        return accountRepository.count();
    }

    @Override
    public AccountResponce deleteAllUberAccount() {
        accountRepository.deleteAll();
        return new AccountResponce("all uber Account delete");
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
    public AccountResponce changeFirstName(String identifier, String changeName) {
        UberAccount foundAccount = findByIdentifier(identifier);
        foundAccount.setFirstName(changeName);
        accountRepository.save(foundAccount);
        return new AccountResponce("first name changed successfully");
    }
        @Override
    public AccountResponce changeLastName(String identifier, String changeName) {
        UberAccount foundAccount = findByIdentifier(identifier);
        foundAccount.setLastName(changeName);
accountRepository.save(foundAccount);
        return new AccountResponce("last name changed successfully");
    }

    @Override
    public AccountResponce changePassword(String identifier, String aneeka) {
        UberAccount foundAccount = findByIdentifier(identifier);
        foundAccount.setPassword(aneeka);
        accountRepository.save(foundAccount);
        return new AccountResponce("password changed successfully");
    }

    @Override
    public AccountResponce changeContactNumber(String identifier, String nuwNumber) {
     UberAccount foundAccount = findByIdentifier(identifier);
     foundAccount.setContactNumber(nuwNumber);
     accountRepository.save(foundAccount);
        return new AccountResponce("phone number changed successfully");
    }

}

