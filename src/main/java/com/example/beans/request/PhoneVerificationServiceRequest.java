package com.example.beans.request;

public class PhoneVerificationServiceRequest {
    private String emailId;
    private String mobileNo;
    private String otp;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
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
        return "PhoneVerificationServiceRequest{" +
                "emailId='" + emailId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}
