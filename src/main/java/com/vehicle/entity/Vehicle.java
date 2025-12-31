package com.vehicle.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Schema(hidden = true)
    private int vehicleId;

    @Column(nullable = false,unique = true)
    @NotBlank(message = "Registration Number Are Required")
    private String registrationNumber;
    @NotNull
    @Column(nullable = false)
    private String vehicleName;
    private String color;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type{
        CAR,MOPED,BIKE,SCOOTER
    }
    @NotNull
    @Column(nullable = false)
    private OffsetDateTime associationActivatedAt;

    private OffsetDateTime associationDeactivatedAt;

    @NotNull
    @Column(nullable = false,name="is_vehicle_active")
    @JsonProperty("vehicleActive")
    private boolean isVehicleActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="resident_id")
    @Schema(hidden = true)
    @JsonBackReference
    private Resident resident;


}