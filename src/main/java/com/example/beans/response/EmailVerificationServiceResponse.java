package com.example.beans.response;

public class EmailVerificationServiceResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RegisterResourceResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
