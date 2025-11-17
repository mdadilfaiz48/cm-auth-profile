package com.example.beans.response;

public class PhoneVerificationResourceResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PhoneVerificationResourceResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
