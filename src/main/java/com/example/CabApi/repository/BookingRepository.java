package com.example.CabApi.repository;

import com.example.CabApi.model.CabBooking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<CabBooking, Integer> {
}
