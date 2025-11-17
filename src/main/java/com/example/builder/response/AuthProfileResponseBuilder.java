package com.example.builder.response;

import com.example.beans.response.EmailVerificationDAOResponse;
import com.example.beans.response.EmailVerificationResourceResponse;
import com.example.beans.response.EmailVerificationServiceResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthProfileResponseBuilder {

    public EmailVerificationResourceResponse buildEmailResourceResponse(EmailVerificationServiceResponse serviceResponse) {
        EmailVerificationResourceResponse response = new EmailVerificationResourceResponse();
        response.setMessage(serviceResponse.getMessage());
        return response;
    }

    public EmailVerificationServiceResponse buildEmailServiceResponse(EmailVerificationDAOResponse daoResponse) {
        EmailVerificationServiceResponse serviceResponse = new EmailVerificationServiceResponse();
        serviceResponse.setMessage(daoResponse.getMessage());
        return serviceResponse;
    }
}
