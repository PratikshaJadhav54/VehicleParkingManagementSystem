package com.vehicle.serviceImpl;

import com.vehicle.entity.Resident;
import com.vehicle.entity.Vehicle;
import com.vehicle.exception.ResidentNotFoundException;
import com.vehicle.repository.ResidentRepository;
import com.vehicle.repository.VehicleRepository;
import com.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ResidentRepository residentRepository;

    @Override
    public Vehicle save(Vehicle vehicle,int resident_id) {
        Resident residentIdInDb=residentRepository.findById(resident_id).orElseThrow(()->new ResidentNotFoundException("Resident not found. Vehicle cannot be created."));
        vehicle.setResident(residentIdInDb);
       return  vehicleRepository.save(vehicle);
    }
}
