package com.example.CabApi.repository;


import com.example.CabApi.model.Cab;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CabsRepository extends MongoRepository<Cab, Integer> {
}
