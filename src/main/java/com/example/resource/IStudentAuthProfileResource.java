package com.example.resource;

import com.example.beans.request.EmailVerificationResourceRequest;
import com.example.beans.request.PhoneVerificationResourceRequest;
import com.example.beans.request.RegisterResourceRequest;
import com.example.beans.response.EmailVerificationResourceResponse;
import com.example.beans.response.PhoneVerificationResourceResponse;
import com.example.beans.response.RegisterResourceResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface IStudentAuthProfileResource {
    public EmailVerificationResourceResponse initEmailVerification(EmailVerificationResourceRequest request);

    public EmailVerificationResourceResponse confirmEmailVerification( EmailVerificationResourceRequest request);

    public PhoneVerificationResourceResponse initPhoneVerification( PhoneVerificationResourceRequest request);

    public RegisterResourceResponse register(RegisterResourceRequest request);
}
