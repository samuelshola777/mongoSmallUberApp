package com.example.mongosmalluberapp.customer.data.repository;

import com.example.mongosmalluberapp.customer.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findCutomerByEmail(String email);
}
