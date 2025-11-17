package com.example.service.impl;

import com.example.beans.request.EmailVerificationDAORequest;
import com.example.beans.request.EmailVerificationServiceRequest;
import com.example.beans.response.EmailVerificationServiceResponse;
import com.example.builder.request.AuthProfileRequestBuilder;
import com.example.builder.response.AuthProfileResponseBuilder;
import com.example.dao.AuthProfileDAO;
import com.example.entity.VerificationEntity;
import com.example.service.IAuthProfileService;
import com.example.utils.AuthProfileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthProfileService implements IAuthProfileService {
    @Autowired
    private AuthProfileDAO dao;

    @Autowired
    private AuthProfileUtils authProfileUtils;
   @Override
    public EmailVerificationServiceResponse initEmailVerification(EmailVerificationServiceRequest serviceRequest) {
        EmailVerificationServiceResponse serviceResponse = new EmailVerificationServiceResponse();

        // dao.findByEmailId("khan56@gmail.com")
       VerificationEntity existingEntity = dao.findByEmailId(serviceRequest.getEmailId());

         // Checking if existing OTP is still valid
       if(existingEntity != null) {
           if(existingEntity.getEmailOtpExpireTime().isAfter(LocalDateTime.now())) {
               serviceResponse.setMessage("OTP already sent to this email and valid till :" + existingEntity.getEmailOtpExpireTime());
               return serviceResponse;
           }
       }

       // Checking if existing OTP is expired, then remove it and generate a new one
       if(existingEntity!= null) {
            if(existingEntity.getEmailOtpExpireTime().isBefore(LocalDateTime.now())){
                String otp = authProfileUtils.generateOtp();
                LocalDateTime expireTime = LocalDateTime.now().plusMinutes(5);
                existingEntity.setEmailOtp(otp);
                existingEntity.setEmailOtpExpireTime(expireTime);
                dao.save(existingEntity);
                // todo: send this OTP to notification service to send email
                serviceResponse.setMessage("New OTP sent and valid for 5 minutes till :"+expireTime);
                return serviceResponse;
            }
       }

       VerificationEntity entity = new VerificationEntity();
       if(existingEntity == null) {

           // Generate new OTP first time
           String otp = authProfileUtils.generateOtp();
           entity.setEmailId(serviceRequest.getEmailId());
           entity.setEmailOtp(otp);
           LocalDateTime expireTime = LocalDateTime.now().plusMinutes(5);
           entity.setEmailOtpExpireTime(expireTime);
           VerificationEntity response = dao.save(entity);
           // send this OTP to notification service to send email
           // Here
           if(response != null) {
               serviceResponse.setMessage("Email verification initiated. please check your email and valid for 5 minutes till :"+expireTime);
           }
           else{
               serviceResponse.setMessage("Failed to initiate email verification.");
           }
       }

        return serviceResponse;
    }

}
