package com.example.beans.request;

public class PhoneVerificationDAORequest {
    private String emailId;
    private String mobileNo;
    private String otp;

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "PhoneVerificationDAORequest{" +
                "mobileNo='" + mobileNo + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}
