package com.example.builder.request;

import com.example.beans.request.EmailVerificationDAORequest;
import com.example.beans.request.EmailVerificationResourceRequest;
import com.example.beans.request.EmailVerificationServiceRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthProfileRequestBuilder {
   public EmailVerificationServiceRequest buildEmailServiceRequest(EmailVerificationResourceRequest request) {
                    EmailVerificationServiceRequest serviceRequest = new EmailVerificationServiceRequest();
                    serviceRequest.setEmailId(request.getEmailId());
                    serviceRequest.setOtp(request.getOtp());
       return serviceRequest;
   }

   public EmailVerificationDAORequest buildEmailDAORequest(EmailVerificationServiceRequest request) {
                    EmailVerificationDAORequest daoRequest = new EmailVerificationDAORequest();
                    daoRequest.setEmailId(request.getEmailId());
                    daoRequest.setOtp(request.getOtp());
       return daoRequest;
   }

}

