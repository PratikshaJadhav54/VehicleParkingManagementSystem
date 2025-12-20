package com.vehicle.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Resident
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
//    @Column(nullable = true)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String fName;

    private String lName;
    @NotNull
    @Column(nullable = false)
    private String flatNo;
    @NotNull
    @Column(nullable = false)
    private long mobilNo;
    @NotNull
    @Column(nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ResidentType residentType;

    public enum ResidentType{
        TENANT,OWNER
    }


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "resident")
    private List<Vehicle> vehicleList;

    @OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "resident")
    private List<Visitors> visitorsList;
}
