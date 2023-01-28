package com.example.mongosmalluberapp.customer.service;

import com.example.mongosmalluberapp.customer.data.model.Customer;
import com.example.mongosmalluberapp.customer.dto.request.CustomerRequest;
import com.example.mongosmalluberapp.customer.dto.responce.CustomerResponce;

public interface CustomerInterface {
   CustomerResponce createCustomer(CustomerRequest customerRequest2);
   long countCustomer();

   CustomerResponce deleteAllCustomer();

   Customer findCutomerByEmail(String email);
}
