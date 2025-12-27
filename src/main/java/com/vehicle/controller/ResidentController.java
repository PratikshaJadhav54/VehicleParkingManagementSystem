
package com.vehicle.controller;

import com.vehicle.dto.response.ResidentResponseDTO;
import com.vehicle.entity.Resident;
import com.vehicle.service.ResidentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllResidents")
    public ResponseEntity<List<Resident>> getAllResidents() {
      List<Resident> allResident =residentService.getAllResidents();
      return new ResponseEntity<>(allResident, HttpStatus.FOUND);
    }

    @GetMapping("/getByResidentName/{f_name}")
    public ResponseEntity<List<Resident>> getResidentByName(@PathVariable ("f_name") String f_name)
    {
        List<Resident> getByName =residentService.getResidentByName(f_name);
        return new ResponseEntity<>(getByName, HttpStatus.FOUND);
    }
}
