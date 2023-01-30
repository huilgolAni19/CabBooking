package com.example.CabApi.repository;

import com.example.CabApi.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver, Integer> { }
