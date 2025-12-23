package com.vehicle.dto.request;

import com.vehicle.entity.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleRequestDTO {

    @NotBlank(message = "registration umber is required")
    private String registrationNumber;

    @NotBlank(message = "vehicle name is required")
    private String vehicleName;

    private String color;

    @NotNull(message = "vehicle type is required")
    private Vehicle.Type type;

    private Boolean vehicleActive;

    public Boolean getVehicleActive() {
        return vehicleActive;
    }

    public void setVehicleActive(Boolean vehicleActive) {
        this.vehicleActive = vehicleActive;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vehicle.Type getType() {
        return type;
    }

    public void setType(Vehicle.Type type) {
        this.type = type;
    }
}
