package com.aslam.mycontact.ventors.api.auth.ventor;

public class RegisterVentorRequest {
    private String ventorName;
    private String email;
    private String mobileNo;

    public RegisterVentorRequest() {
    }

    public RegisterVentorRequest(String ventorName,
                                 String email,
                                 String mobileNo) {
        this.ventorName = ventorName;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public String getVentorName() {
        return ventorName;
    }

    public void setVentorName(String ventorName) {
        this.ventorName = ventorName;
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
}
