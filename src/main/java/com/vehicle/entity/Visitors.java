
package com.vehicle.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Visitors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int visitorsId;
    private String visitorsName;
    private String vehicleName;
    private String vehicleRegistrationNumber;
    private String visitPurpose;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private long phoneNumber;
    private boolean  isActiveVisitor;

    @Enumerated(EnumType.STRING)
    private VisitorsType visitorsType;

    public enum VisitorsType{
        GUEST,DELIVERY}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="resident_id")
    private Resident resident;

}
