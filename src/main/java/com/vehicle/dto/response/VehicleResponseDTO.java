package com.vehicle.dto.response;

import com.vehicle.entity.Vehicle;
import lombok.Data;


public class VehicleResponseDTO {

    private Long id;
    private String vehicleNumber;
    private String color;
    private Vehicle.Type type;
    private Boolean vehicleActive;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getVehicleNumber() {
//        return vehicleNumber;
//    }
//
//    public void setVehicleNumber(String vehicleNumber) {
//        this.vehicleNumber = vehicleNumber;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public Vehicle.Type getType() {
//        return type;
//    }
//
//    public void setType(Vehicle.Type type) {
//        this.type = type;
//    }
//
//    public Boolean getVehicleActive() {
//        return vehicleActive;
//    }
//
//    public void setVehicleActive(Boolean vehicleActive) {
//        this.vehicleActive = vehicleActive;
//    }
}
