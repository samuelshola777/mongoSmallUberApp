package com.example.mongosmalluberapp.ride.data.repository;

import com.example.mongosmalluberapp.ride.data.model.Ride;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RideRepository extends MongoRepository <Ride, String> {
}
