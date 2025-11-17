package com.example.beans.response;

public class EmailVerificationResourceResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmailVerificationResourceResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
