package com.example.service;

import com.example.beans.request.EmailVerificationServiceRequest;
import com.example.beans.response.EmailVerificationServiceResponse;

public interface IAuthProfileService {

    public EmailVerificationServiceResponse initEmailVerification(EmailVerificationServiceRequest serviceRequest);
}
