package com.example.builder.request;

import com.example.beans.request.*;
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

    public PhoneVerificationServiceRequest buildPhoneServiceRequest(PhoneVerificationResourceRequest request) {
        PhoneVerificationServiceRequest serviceRequest = new PhoneVerificationServiceRequest();
        serviceRequest.setEmailId(request.getEmailId());
        serviceRequest.setMobileNo(request.getMobileNo());
        serviceRequest.setOtp(request.getOtp());
        return serviceRequest;
    }

    public PhoneVerificationDAORequest buildPhoneDAORequest(PhoneVerificationServiceRequest request) {
        PhoneVerificationDAORequest daoRequest = new PhoneVerificationDAORequest();
        daoRequest.setEmailId(request.getEmailId());
        daoRequest.setMobileNo(request.getMobileNo());
        daoRequest.setOtp(request.getOtp());
        return daoRequest;
    }

    public RegisterServiceRequest buildRegisterServiceRequest(RegisterResourceRequest request) {
        RegisterServiceRequest serviceRequest = new RegisterServiceRequest();
        serviceRequest.setEmailId(request.getEmailId());
        serviceRequest.setFirstName(request.getFirstName());
        serviceRequest.setLastName(request.getLastName());
        serviceRequest.setDateOfBirth(request.getDateOfBirth());
        serviceRequest.setUserName(request.getUserName());
        serviceRequest.setPassword(request.getPassword());

        return serviceRequest;
    }
}

