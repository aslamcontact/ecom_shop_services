package com.aslam.mycontact.ventors.daolayer;

import com.aslam.mycontact.ventors.daolayer.ventordetails.Address;
import com.aslam.mycontact.ventors.daolayer.ventordetails.Details;

import com.aslam.mycontact.ventors.daolayer.ventordetails.VentorPersonalDetails;

public class ventor {

    private String email;
    private Integer mobileNumber;
    private String password;
    private String ventorName;
    private String ventorBusinessType;
    private VentorPersonalDetails ventorPersonalDetails;
    private Details details;
    private Address address;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVentorName() {
        return ventorName;
    }

    public void setVentorName(String ventorName) {
        this.ventorName = ventorName;
    }

    public String getVentorBusinessType() {
        return ventorBusinessType;
    }

    public void setVentorBusinessType(String ventorBusinessType) {
        this.ventorBusinessType = ventorBusinessType;
    }

    public VentorPersonalDetails getVentorPersonalDetails() {
        return ventorPersonalDetails;
    }

    public void setVentorPersonalDetails(VentorPersonalDetails ventorPersonalDetails) {
        this.ventorPersonalDetails = ventorPersonalDetails;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
