package com.vehicle.controller;

import com.vehicle.entity.Vehicle;
import com.vehicle.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/save/{resident_id}")
    public ResponseEntity<Vehicle> saveVehicle(@Valid @RequestBody Vehicle vehicle, @PathVariable("resident_id") int resident_id)
    {
        Vehicle savedVehicle=vehicleService.save(vehicle,resident_id);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }

}
