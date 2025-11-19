package com.example.beans.response;

public class RegisterServiceResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RegisterServiceResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
