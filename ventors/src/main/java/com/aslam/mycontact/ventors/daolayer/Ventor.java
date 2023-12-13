package com.aslam.mycontact.ventors.daolayer;

import com.aslam.mycontact.ventors.daolayer.ventordetails.Address;
import com.aslam.mycontact.ventors.daolayer.ventordetails.Details;

import com.aslam.mycontact.ventors.daolayer.ventordetails.VentorPersonalDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Ventor implements UserDetails {
    @Id
    private Integer ventorId;
    private String email;
    private Integer mobileNumber;
    private String password;
    private String ventorName;
    private String ventorBusinessType;
    private VentorPersonalDetails ventorPersonalDetails;
    private Details details;


    private Address address;
    @Enumerated(EnumType.STRING)
    private  VentorRoles roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roles.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getVentorId() {
        return ventorId;
    }

    public void setVentorId(Integer ventorId) {
        this.ventorId = ventorId;
    }

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

    public VentorRoles getRoles() {
        return roles;
    }

    public void setRoles(VentorRoles roles) {
        this.roles = roles;
    }
}
