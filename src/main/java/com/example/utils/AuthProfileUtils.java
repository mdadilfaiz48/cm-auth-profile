package com.example.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class AuthProfileUtils {
    public static String generateOtp(){
        SecureRandom secureRandom = new SecureRandom();
        int otp = secureRandom.nextInt(900000) + 100000;
        return String.valueOf(otp);
    }

    public static String generateVerificationId() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(16);
        sb.append((char) ('1' + secureRandom.nextInt(9)));
        for (int i = 1; i < 16; i++) {
            sb.append((char) ('0' + secureRandom.nextInt(10)));
        }
        return sb.toString();
    }

    public static String generateUserId() {
        SecureRandom secureRandom = new SecureRandom();
        char[] ALPHANUMERIC_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder sb = new StringBuilder(12);
        for (int i = 0; i < 12; i++) {
            sb.append(ALPHANUMERIC_UPPER[secureRandom.nextInt(ALPHANUMERIC_UPPER.length)]);
        }
        return sb.toString();
    }
}
