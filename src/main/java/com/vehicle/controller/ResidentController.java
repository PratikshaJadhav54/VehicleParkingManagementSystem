
package com.vehicle.controller;

import com.vehicle.entity.Resident;
import com.vehicle.service.ResidentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resident")
public class ResidentController {

    @Autowired
    ResidentService residentService;

    @PostMapping("/save")
    public ResponseEntity<Resident> save(@Valid  @RequestBody Resident resident)
    {
        Resident savedResident=residentService.saveResident(resident);
        return new ResponseEntity<>(savedResident, HttpStatus.CREATED);
    }
}
