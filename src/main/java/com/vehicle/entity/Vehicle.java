package com.vehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(nullable = false)
    private int vehicleId;
    @NotNull
    @Column(nullable = false)
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
        CAR,MOPED,BIKE
    }
    @NotNull
    @Column(nullable = false)
    private LocalDateTime associationActivatedAt;
    private LocalDateTime associationDeactivatedAt;
    @NotNull
    @Column(nullable = false)
    private boolean isVehicleActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="resident_id")
    private Resident resident;
}
