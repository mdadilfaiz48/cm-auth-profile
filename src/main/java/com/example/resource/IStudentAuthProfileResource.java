package com.example.resource;

import com.example.beans.request.EmailVerificationResourceRequest;
import com.example.beans.response.EmailVerificationResourceResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface IStudentAuthProfileResource {
    public EmailVerificationResourceResponse initEmailVerification(EmailVerificationResourceRequest request);

    public EmailVerificationResourceResponse confirmEmailVerification( EmailVerificationResourceRequest request);
}
