package com.example.CabApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cab_master")
public class Cab {

    @Id int cabId;
    String vehicleType;
    String vehicleNumber;
    int driverId;
    String vehicleBrandName;
    String vehicleModelName;
    String registeredDate;
    String chassisNumber;

}
