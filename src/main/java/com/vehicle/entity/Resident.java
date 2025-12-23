
package com.vehicle.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Integer id;

    @NotBlank(message = "First Name is mandatory")
    @Column(nullable = false)
    private String fName;

    @NotBlank(message = "Last Name is mandatory")
    private String lName;

    @NotBlank(message = "Flat Number is mandatory")
    @Column(nullable = false)
    private String flatNo;

    @NotNull(message = "Mobile Number is mandatory")
    @Column(nullable = false)
    private Long mobilNo;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email address")
//    @Pattern(
//            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
//            message = "Invalid email format"
//    )
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "Resident Type is mandatory")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResidentType residentType;

    public enum ResidentType {
        TENANT,
        OWNER
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resident")
    @JsonBackReference
    private List<Vehicle> vehicleList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resident")
    @JsonIgnore
    private List<Visitors> visitorsList;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
////        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
}
