package com.example.beans.response;

public class RegisterDAOResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RegisterDAOResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
