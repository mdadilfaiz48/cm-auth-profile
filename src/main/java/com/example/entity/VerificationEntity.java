package com.example.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document (collection = "verification")
public class VerificationEntity {
        @Field("emailId")
        private String emailId;
        @Field("email_otp")
        private String emailOtp;
        @Field("email_otp_expire_time")
        private LocalDateTime emailOtpExpireTime;
        @Field("is_email_verified")
        private boolean isEmailVerified;
        @Field("mobile")
        private String mobile;
        @Field("mobile_otp")
        private String mobileOtp;
        @Field("mobile_otp_expire_time")
        private LocalDateTime mobileOtpExpireTime;
        @Field("is_mobile_verified")
        private boolean isMobileVerified;
        @Field("is_verification_completed")
        private boolean isVerificationCompleted;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailOtp() {
        return emailOtp;
    }

    public void setEmailOtp(String emailOtp) {
        this.emailOtp = emailOtp;
    }

    public LocalDateTime getEmailOtpExpireTime() {
        return emailOtpExpireTime;
    }

    public void setEmailOtpExpireTime(LocalDateTime emailOtpExpireTime) {
        this.emailOtpExpireTime = emailOtpExpireTime;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileOtp() {
        return mobileOtp;
    }

    public void setMobileOtp(String mobileOtp) {
        this.mobileOtp = mobileOtp;
    }

    public LocalDateTime getMobileOtpExpireTime() {
        return mobileOtpExpireTime;
    }

    public void setMobileOtpExpireTime(LocalDateTime mobileOtpExpireTime) {
        this.mobileOtpExpireTime = mobileOtpExpireTime;
    }

    public boolean isMobileVerified() {
        return isMobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        isMobileVerified = mobileVerified;
    }

    public boolean isVerificationCompleted() {
        return isVerificationCompleted;
    }

    public void setVerificationCompleted(boolean verificationCompleted) {
        isVerificationCompleted = verificationCompleted;
    }

    //       ******************** mask methods to hide sensitive information ***********************
    private String maskEmail(String email) {
        if (email == null || !email.contains("@")) return "****";
        String[] parts = email.split("@");
        String name = parts[0];
        String domain = parts[1];

        String maskedName = name.charAt(0) + "****";
        return maskedName + "@" + domain;
    }

    private String maskMobile(String mobile) {
        if (mobile == null || mobile.length() < 3) return "*****";
        int len = mobile.length();
        return mobile.substring(0, 2) + "*****" + mobile.substring(len - 2);
    }

    private String maskPassword(String pass) {
        if (pass == null) return "******";
        return "******";
    }

    @Override

    public String toString() {
        return "EmailEntity{" +
                "email='" + maskEmail(emailId) + '\'' +
                ", emailOtp='" + "*****" + '\'' +
                ", isEmailVerified=" + isEmailVerified +
                ", mobile='" + maskMobile(mobile) + '\'' +
                ", mobileOtp='" + "*****" + '\'' +
                ", isMobileVerified=" + isMobileVerified +
                ", isVerificationCompleted=" + isVerificationCompleted +
                '}';
    }

}
