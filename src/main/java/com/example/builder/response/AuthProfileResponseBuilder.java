package com.example.builder.response;

import com.example.beans.response.*;
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

    public PhoneVerificationResourceResponse buildPhoneResourceResponse(PhoneVerificationServiceResponse serviceResponse) {
        PhoneVerificationResourceResponse response = new PhoneVerificationResourceResponse();
        response.setMessage(serviceResponse.getMessage());
        return response;
    }

    public PhoneVerificationServiceResponse buildPhoneServiceResponse(PhoneVerificationDAOResponse daoResponse) {
        PhoneVerificationServiceResponse serviceResponse = new PhoneVerificationServiceResponse();
        serviceResponse.setMessage(daoResponse.getMessage());
        return serviceResponse;
    }

    public RegisterServiceResponse buildRegisterServiceResponse(RegisterDAOResponse daoResponse) {
        RegisterServiceResponse serviceResponse = new RegisterServiceResponse();
        serviceResponse.setMessage(daoResponse.getMessage());
        return serviceResponse;
    }

    public RegisterResourceResponse buildRegisterResourceResponse(RegisterServiceResponse serviceResponse) {
        RegisterResourceResponse response = new RegisterResourceResponse();
        response.setMessage(serviceResponse.getMessage());
        return response;
    }
}
