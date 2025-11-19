package com.example.service;

import com.example.beans.request.EmailVerificationServiceRequest;
import com.example.beans.request.PhoneVerificationServiceRequest;
import com.example.beans.request.RegisterServiceRequest;
import com.example.beans.response.EmailVerificationServiceResponse;
import com.example.beans.response.PhoneVerificationServiceResponse;
import com.example.beans.response.RegisterServiceResponse;

public interface IAuthProfileService {

    public EmailVerificationServiceResponse initEmailVerification(EmailVerificationServiceRequest serviceRequest);

    public EmailVerificationServiceResponse confirmEmailVerification(EmailVerificationServiceRequest serviceRequest);

    public PhoneVerificationServiceResponse initPhoneVerification(PhoneVerificationServiceRequest serviceRequest);

    public PhoneVerificationServiceResponse confirmPhoneVerification(PhoneVerificationServiceRequest serviceRequest);

    public RegisterServiceResponse register(RegisterServiceRequest serviceRequest);
}
