package com.vehicle.serviceImpl;

import com.vehicle.entity.Resident;
import com.vehicle.repository.ResidentRepository;
import com.vehicle.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidentServiceImpl implements ResidentService {

    @Autowired
    ResidentRepository residentRepository;

    @Override
    public Resident saveResident(Resident resident) {
        Resident residentInDb=residentRepository.save(resident);
        return residentInDb;
    }
}
