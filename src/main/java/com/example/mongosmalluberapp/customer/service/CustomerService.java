package com.example.mongosmalluberapp.customer.service;

import com.example.mongosmalluberapp.customer.data.model.Customer;
import com.example.mongosmalluberapp.customer.data.repository.CustomerRepository;
import com.example.mongosmalluberapp.customer.dto.request.CustomerRequest;
import com.example.mongosmalluberapp.customer.dto.responce.CustomerResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements  CustomerInterface{
@Autowired
CustomerRepository customerRepository;

    @Override
    public CustomerResponce createCustomer(CustomerRequest customerRequest2) {
        if ( customerRepository.findCutomerByEmail(customerRequest2.getEmail() ) != null){

        }
        Customer builtCustomer = Customer.builder().email(customerRequest2.getEmail()).
                dropLocation(customerRequest2.
                        getPickUpLocation()).
                pickUpLocation(customerRequest2.
                        getDropLocation()).build();
        customerRepository.save(builtCustomer);
        return new CustomerResponce("custer detail's extracted successfully");
    }

    @Override
    public long countCustomer() {
        return customerRepository.count();
    }

    @Override
    public CustomerResponce deleteAllCustomer() {
        customerRepository.deleteAll();
        return new CustomerResponce("all customer deleted");
    }

    @Override
    public Customer findCutomerByEmail(String email) {
        return customerRepository.findCutomerByEmail(email);
    }


}
