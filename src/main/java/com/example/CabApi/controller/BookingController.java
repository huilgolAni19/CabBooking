package com.example.CabApi.controller;


import com.example.CabApi.model.*;
import com.example.CabApi.repository.BookingRepository;
import com.example.CabApi.repository.CabsRepository;
import com.example.CabApi.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/Booking")
public class BookingController {


    @Autowired
    BookingRepository repository;

    @Autowired
    CabsRepository cabsRepository;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/bookCab")
    public ResponseEntity<?> bookCab(@RequestBody CabBooking booking) {
        CabBooking booking1 = repository.save(booking);
        CabBookingResponse response = new CabBookingResponse();
        response.setStatus("Success");
        response.setStatusCode(200);
        response.setMessage("Your cab was booked successfully....");
        response.setBooking(booking1);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/getCabBookings")
    public ResponseEntity<AllCabBookingResponse> getAllCabBookings() {

        AllCabBookingResponse response = new AllCabBookingResponse();

        List<CabBookingDetails> bookingDetails = new ArrayList<>();

        List<CabBooking> bookings = repository.findAll();
        for(CabBooking b : bookings) {
            Cab c = cabsRepository.findById(b.getCabId()).get();
            User u = userRepository.findById(b.getUserId()).get();

            CabBookingDetails cbd = new CabBookingDetails();
            cbd.setBookingId(b.getBookingId());
            cbd.setCab(c);
            cbd.setCabBooking(b);
            cbd.setUser(u);
            bookingDetails.add(cbd);
        }
        if (bookings.size() > 0) {
            response.setStatusCode(200);
            response.setStatus("Success");
            response.setMessage("Bookings Found");
            response.setBookings(bookingDetails);
        } else {
            response.setStatusCode(204);
            response.setStatus("Success");
            response.setMessage("Bookings Not Found");
            response.setBookings(bookingDetails);
        }
        return ResponseEntity.ok(response);
    }
}
