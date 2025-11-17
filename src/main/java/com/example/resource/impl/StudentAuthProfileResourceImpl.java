package com.example.resource.impl;

import com.example.beans.request.EmailVerificationResourceRequest;
import com.example.beans.request.EmailVerificationServiceRequest;
import com.example.beans.request.PhoneVerificationResourceRequest;
import com.example.beans.request.RegisterResourceRequest;
import com.example.beans.response.EmailVerificationResourceResponse;
import com.example.beans.response.EmailVerificationServiceResponse;
import com.example.beans.response.PhoneVerificationResourceResponse;
import com.example.beans.response.RegisterResourceResponse;
import com.example.builder.request.AuthProfileRequestBuilder;
import com.example.builder.response.AuthProfileResponseBuilder;
import com.example.resource.IStudentAuthProfileResource;
import com.example.service.IAuthProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth/student")
public class StudentAuthProfileResourceImpl implements IStudentAuthProfileResource {
    @Autowired
    IAuthProfileService service;
    @Autowired
    AuthProfileRequestBuilder requestBuilder;
    @Autowired
    AuthProfileResponseBuilder responseBuilder;
    @PostMapping(value = "/verify/email/init")
    public EmailVerificationResourceResponse initEmailVerification(@RequestBody  EmailVerificationResourceRequest request) {

        EmailVerificationServiceRequest serviceRequest =  requestBuilder.buildEmailServiceRequest(request );

        EmailVerificationServiceResponse serviceResponse = service.initEmailVerification(serviceRequest);
        Map<String,String> message = new HashMap<>();

        EmailVerificationResourceResponse resourceResponse = responseBuilder.buildEmailResourceResponse(serviceResponse);
        // Implementation logic here
        return resourceResponse;
    }

    @PostMapping(value = "/verify/email/confirm")
    public EmailVerificationResourceResponse confirmEmailVerification(@RequestBody EmailVerificationResourceRequest request) {
        // Implementation logic here
        return null;
    }

    @PostMapping(value = "/verify/phone/init")
    public PhoneVerificationResourceResponse initPhoneVerification(@RequestBody PhoneVerificationResourceRequest request) {
        // Implementation logic here
        return null;
    }

    @PostMapping(value="/verify/phone/confirm")
    public PhoneVerificationResourceResponse confirmPhoneVerification(@RequestBody PhoneVerificationResourceRequest request) {
        // Implementation logic here
        return null;
    }

    @PostMapping(value = "/register")
    public RegisterResourceResponse register(@RequestBody RegisterResourceRequest request){
        return null;
    }


}
