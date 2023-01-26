package com.example.mongosmalluberapp.driver.data.repository;

import com.example.mongosmalluberapp.account.data.model.UberAccount;
import com.example.mongosmalluberapp.driver.data.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface DriverRepository extends MongoRepository <Driver, String> {


    


    Driver findByAccount(UberAccount foundAccount);

    Driver findByDriverLocation(String ikeja);
}
