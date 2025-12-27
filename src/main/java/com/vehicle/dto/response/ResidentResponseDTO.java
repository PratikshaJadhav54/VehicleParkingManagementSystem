package com.vehicle.dto.response;


import com.vehicle.dto.request.VehicleRequestDTO;
import com.vehicle.entity.Resident;
import lombok.Data;

import java.util.List;

@Data
public class ResidentResponseDTO {

    private Integer id;
    private String fName;
    private String lName;
    private String flatNo;
    private Long mobilNo;
    private String email;
    private Resident.ResidentType residentType;
    private List<VehicleRequestDTO> vehicles;
}
//
//public class ResidentResponseDTO {
//
//    private Long id;
//    private String fname;
//    private String email;
//    private String mobileNo;
//    private List<VehicleResponseDTO> vehicleResponseDTOList;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFname() {
//        return fname;
//    }
//
//    public void setFname(String fname) {
//        this.fname = fname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getMobileNo() {
//        return mobileNo;
//    }
//
//    public void setMobileNo(String mobileNo) {
//        this.mobileNo = mobileNo;
//    }
//
//    public List<VehicleResponseDTO> getVehicleResponseDTOList() {
//        return vehicleResponseDTOList;
//    }
//
//    public void setVehicleResponseDTOList(List<VehicleResponseDTO> vehicleResponseDTOList) {
//        this.vehicleResponseDTOList = vehicleResponseDTOList;
//    }
//}
