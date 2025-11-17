package com.example.beans.request;

public class PhoneVerificationResourceRequest {
    private String mobileNo;
    private String otp;

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
        return "PhoneVerificationResourceRequest{" +
                "mobileNo='" + mobileNo + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}
