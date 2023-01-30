package com.example.CabApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabBooking {

    int cabId;
    int userId;
    @Id int bookingId;
    String fromAddress;
    String toAddress;
}
