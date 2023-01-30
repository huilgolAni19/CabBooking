package com.example.CabApi.controller;


import com.example.CabApi.model.Cab;
import com.example.CabApi.model.CabsResponse;
import com.example.CabApi.model.CommonResponse;
import com.example.CabApi.model.GetCabsResponse;
import com.example.CabApi.repository.CabsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/Cab")
public class CabsController {


    @Autowired
    private CabsRepository repository;

    @PostMapping("/registerCab")
    public ResponseEntity<CabsResponse> registerCab(@RequestBody Cab cab) {
        Cab saved = repository.save(cab);
        CabsResponse cr = new CabsResponse();
        cr.setCab(saved);
        cr.setStatusCode(200);
        cr.setStatus("Success");
        cr.setMessage("Cab Registered Successfully..");
        return ResponseEntity.ok(cr);
    }

    @GetMapping("/getCabs")
    public ResponseEntity<GetCabsResponse> getAllCabs() {
        GetCabsResponse cabsResponse = new GetCabsResponse();
        List<Cab> data = repository.findAll();
        if (data.size() > 0) {
            cabsResponse.setStatusCode(200);
            cabsResponse.setStatus("Success");
            cabsResponse.setMessage("Cabs Found");

        } else {

            cabsResponse.setStatusCode(204);
            cabsResponse.setStatus("Success");
            cabsResponse.setMessage("Cabs Not Found");
        }

        cabsResponse.setData(data);
        return ResponseEntity.ok(cabsResponse);
    }


    @GetMapping("/getCab/{id}")
    public ResponseEntity<CabsResponse> getCabById(@PathVariable int id) {

        CabsResponse cb = new CabsResponse();
        Cab cab;
        try {

            cab = repository.findById(id).get();
            cb.setStatusCode(200);
            cb.setStatus("Success");
            cb.setMessage("Cab Found");

        } catch (NoSuchElementException e) {

            cab = null;
            cb.setStatusCode(204);
            cb.setStatus("Success");
            cb.setMessage("Cab Not Found");
        }
        cb.setCab(cab);

        return ResponseEntity.ok(cb);
    }

    @PutMapping("/updateCabDetails/{id}")
    public ResponseEntity<CabsResponse> updateCabData(@RequestBody Cab cab, @PathVariable int id) {

        Cab update = repository.findById(id).map( cb -> {
            cb.setChassisNumber(cab.getChassisNumber());
            cb.setDriverId(cab.getDriverId());
            cb.setRegisteredDate(cab.getRegisteredDate());
            cb.setVehicleBrandName(cab.getVehicleBrandName());
            cb.setVehicleModelName(cab.getVehicleModelName());
            cb.setVehicleNumber(cab.getVehicleNumber());

            return repository.save(cb);
        }).orElseGet(() -> {
            cab.setCabId(id);
            return  repository.save(cab);
        });

        CabsResponse cabsResponse = new CabsResponse();
        cabsResponse.setStatusCode(200);
        cabsResponse.setStatus("Success");
        cabsResponse.setMessage("Cab Details Updated Successfully");
        cabsResponse.setCab(update);
        return ResponseEntity.ok(cabsResponse);
    }

    @DeleteMapping("/deleteCab/{id}")
    public ResponseEntity<CommonResponse> deleteCab(@PathVariable int id) {
        repository.deleteById(id);
        CommonResponse cr = new CabsResponse();
        cr.setStatusCode(200);
        cr.setStatus("Success");
        cr.setMessage("Cab Deleted Successfully...");
        return ResponseEntity.ok(cr);
    }
}
