package com.example.mongosmalluberapp.account.data.repository;

import com.example.mongosmalluberapp.account.data.model.UberAccount;
import com.example.mongosmalluberapp.account.dto.response.AccountResponce;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<UberAccount, Integer> {

    void deleteAllByIdentifier(String horse);

    UberAccount findByIdentifier(String horse);
}
