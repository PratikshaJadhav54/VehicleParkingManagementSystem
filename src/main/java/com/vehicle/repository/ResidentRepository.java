package com.vehicle.repository;

import com.vehicle.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidentRepository extends JpaRepository<Resident,Integer> {

//    @Query("SELECT r from resident r left outer join vehicle v")
//    List<Resident> findAllWithVehicles();

    @Query("SELECT r FROM Resident r WHERE r.fName = :fName and r.lName=:lName")
    List<Resident> findByFirstName(@Param("fName") String fName,@Param("lName") String lName);
}
