package com.example.beans.response;

public class PhoneVerificationDAOResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PhoneVerificationDAOResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
