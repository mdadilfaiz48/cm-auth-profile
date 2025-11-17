package com.example.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class AuthProfileUtils {
    public String generateOtp(){
        SecureRandom secureRandom = new SecureRandom();
        int otp = secureRandom.nextInt(900000) + 100000;
        return String.valueOf(otp);
    }
}
