package com.vehicle.service;

import com.vehicle.entity.Resident;

import java.util.List;

public interface ResidentService {

    Resident saveResident(Resident resident);

    List<Resident> getAllResidents();

    List<Resident> getResidentByName(String f_name);
}