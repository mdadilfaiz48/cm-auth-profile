package com.example.beans.request;

public class EmailVerificationDAORequest {
    private String emailId;
    private String otp;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }


    private String maskEmail(String email) {
        if (email == null || !email.contains("@")) return "****";
        String[] parts = email.split("@");
        String name = parts[0];
        String domain = parts[1];

        String maskedName = name.charAt(0) + "****";
        return maskedName + "@" + domain;
    }

    private String maskOtp(String otp) {
        if (otp == null || otp.isEmpty()) return "****";
        return "****";  // hide full OTP
    }

    @Override

    public String toString() {
        return "EmailVerificationResourceRequest{" +
                "emailId='" + maskEmail(emailId) + '\'' +
                ", otp='" + maskOtp(otp) + '\'' +
                '}';
    }

}
