package com.example.mongosmalluberapp.account.service;

import com.example.mongosmalluberapp.account.data.model.UberAccount;
import com.example.mongosmalluberapp.account.dto.request.AccountRequest;
import com.example.mongosmalluberapp.account.dto.response.AccountResponce;

public interface AccountSerivice {
    AccountResponce createUberAccount(AccountRequest accountRequest);

    long countAccount();

    AccountResponce deleteAllUberAccount();


    void deleteByIdentifier(String horse);

    UberAccount findByIdentifier(String horse);

    AccountResponce changeFirstName(String identifier, String changeName);

    AccountResponce changeLastName(String horse, String sonOfGod);

    AccountResponce changePassword(String ship, String aneeka);

    AccountResponce changeContactNumber(String identifier, String nuwNumber);
}
