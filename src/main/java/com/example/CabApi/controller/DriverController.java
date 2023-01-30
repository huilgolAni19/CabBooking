package com.example.CabApi.controller;

import com.example.CabApi.model.*;
import com.example.CabApi.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/Driver")
public class DriverController {

    @Autowired
    DriverRepository driverRepository;

    @PostMapping("/registerDriver")
    public ResponseEntity<DriverResponse> registerDriver(@RequestBody Driver driver) {

        Driver savedDriver = driverRepository.save(driver);

        DriverResponse driverResponse = new DriverResponse();
        driverResponse.setStatusCode(200);
        driverResponse.setStatus("Success");
        driverResponse.setMessage("Driver Registered Successfully..");
        driverResponse.setDriver(savedDriver);

        return ResponseEntity.ok(driverResponse);
    }


    @GetMapping("/getDrivers")
    public ResponseEntity<GetDriversResponse> getDriversList() {
        GetDriversResponse response = new GetDriversResponse();
        List<Driver> data = driverRepository.findAll();
        if (data.size() > 0) {

            response.setMessage("Drivers Data Found.");
            response.setStatus("Success");
            response.setStatusCode(200);

        } else {

            response.setMessage("Drivers Data Not Found.");
            response.setStatus("Success");
            response.setStatusCode(204);
        }

        response.setData(data);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/getDriver/{id}")
    public ResponseEntity<DriverResponse> getDriverById(@PathVariable int id) {
        DriverResponse response = new DriverResponse();
        try {

            Driver d = driverRepository.findById(id).get();
            response.setDriver(d);
            response.setStatus("Success");
            response.setStatusCode(200);
            response.setMessage("Found Driver Data.");

        } catch (NoSuchElementException e) {
            response.setDriver(null);
            response.setStatus("Success");
            response.setStatusCode(204);
            response.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/deleteDriver")
    public ResponseEntity<CommonResponse> deleteDriver(@PathVariable int id) {

        CommonResponse response = new CabsResponse();

        driverRepository.deleteById(id);
        response.setStatusCode(200);
        response.setStatus("Success");
        response.setMessage("Driver Deleted Successfully...");

        return ResponseEntity.ok(response);
    }

}
