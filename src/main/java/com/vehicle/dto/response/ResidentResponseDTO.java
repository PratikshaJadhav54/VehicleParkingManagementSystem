package com.vehicle.dto.response;


import java.util.List;

public class ResidentResponseDTO {

    private Long id;
    private String fname;
    private String email;
    private String mobileNo;
    private List<VehicleResponseDTO> vehicleResponseDTOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public List<VehicleResponseDTO> getVehicleResponseDTOList() {
        return vehicleResponseDTOList;
    }

    public void setVehicleResponseDTOList(List<VehicleResponseDTO> vehicleResponseDTOList) {
        this.vehicleResponseDTOList = vehicleResponseDTOList;
    }
}
