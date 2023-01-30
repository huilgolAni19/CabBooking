package com.example.CabApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "driver_master")
public class Driver {

    @Id
    int driverId;
    String driverName;
    int age;
    String phoneNumber;
    String driverAddress;

}
