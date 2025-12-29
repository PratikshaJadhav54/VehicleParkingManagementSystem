
package com.vehicle.serviceImpl;

import com.vehicle.dto.request.VehicleRequestDTO;
import com.vehicle.dto.response.ResidentResponseDTO;
import com.vehicle.entity.Resident;
import com.vehicle.entity.Vehicle;
import com.vehicle.exception.ConstraintViolationFirstNameException;
import com.vehicle.exception.ConstraintViolationLastNameException;
import com.vehicle.exception.ResidentNotFoundException;
import com.vehicle.repository.ResidentRepository;
import com.vehicle.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentServiceImpl implements ResidentService {

    @Autowired
    ResidentRepository residentRepository;

    @Override
    public Resident saveResident(Resident resident) {
        if (resident.getVehicleList() != null) {
            resident.getVehicleList().forEach(vehicle -> {
                vehicle.setResident(resident);
            });
        }
        return residentRepository.save(resident);
    }

    @Override
    public List<Resident> getAllResidents() {
      List<Resident> residentInDb=residentRepository.findAll();
        return residentInDb;
    }

    @Override
    public List<Resident> getResidentByName(String f_name, String l_name) {

        if (!f_name.matches("^[A-Za-z]+$")) {
            throw new ConstraintViolationFirstNameException("First name allows only string values");
        }

        if (!l_name.matches("^[A-Za-z]+$")) {
            throw new ConstraintViolationLastNameException("Last name allows only string values");
        }

        List<Resident> findByName =
                residentRepository.findByFirstName(f_name, l_name);

        if (findByName.isEmpty()) {
            throw new ResidentNotFoundException("Resident Not Found");
        }

        return findByName;
    }

}

