package com.example.CabApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabBookingDetails {

    int bookingId;
    Cab cab;
    User user;
    CabBooking cabBooking;
}
