package com.example.beans.response;

public class AuthProfileResourceResponse {
    private String message;
    private UserDetails details;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "AuthProfileResourceResponse{" +
                "message='" + message + '\'' +
                ", details=" + details +
                '}';
    }
}
