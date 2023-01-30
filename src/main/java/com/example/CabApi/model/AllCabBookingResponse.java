package com.example.CabApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllCabBookingResponse extends CommonResponse {
    List<CabBookingDetails> bookings;
}
