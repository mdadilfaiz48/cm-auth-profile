package com.example.resource.impl;

import com.example.beans.request.*;
import com.example.beans.response.*;
import com.example.builder.request.AuthProfileRequestBuilder;
import com.example.builder.response.AuthProfileResponseBuilder;
import com.example.resource.IStudentAuthProfileResource;
import com.example.service.IAuthProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping(value = "/auth/student",consumes = MediaType.APPLICATION_JSON_VALUE)
public class StudentAuthProfileResourceImpl implements IStudentAuthProfileResource {
    @Autowired
    IAuthProfileService service;
    @Autowired
    AuthProfileRequestBuilder requestBuilder;
    @Autowired
    AuthProfileResponseBuilder responseBuilder;

    @PostMapping(value = "/verify/email/init", consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmailVerificationResourceResponse initEmailVerification(@RequestBody  EmailVerificationResourceRequest request) {
        System.out.println("StudentAuthProfileResourceImpl.initEmailVerification==================================>"+request);

        EmailVerificationServiceRequest serviceRequest =  requestBuilder.buildEmailServiceRequest(request );

        EmailVerificationServiceResponse serviceResponse = service.initEmailVerification(serviceRequest);

        EmailVerificationResourceResponse resourceResponse = responseBuilder.buildEmailResourceResponse(serviceResponse);

        System.out.println("StudentAuthProfileResourceImpl.initEmailVerification========================");
        return resourceResponse;
    }

    @PostMapping(value = "/verify/email/confirm", consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmailVerificationResourceResponse confirmEmailVerification(@RequestBody EmailVerificationResourceRequest request) {

         EmailVerificationServiceRequest serviceRequest =    requestBuilder.buildEmailServiceRequest(request);

         EmailVerificationServiceResponse serviceResponse = service.confirmEmailVerification(serviceRequest);

         EmailVerificationResourceResponse resourceResponse =  responseBuilder.buildEmailResourceResponse(serviceResponse);

        return resourceResponse;
    }

    @PostMapping(value = "/verify/phone/init", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PhoneVerificationResourceResponse initPhoneVerification(@RequestBody PhoneVerificationResourceRequest request) {

        PhoneVerificationServiceRequest serviceRequest =  requestBuilder.buildPhoneServiceRequest(request);

           PhoneVerificationServiceResponse serviceResponse =   service.initPhoneVerification(serviceRequest);

           PhoneVerificationResourceResponse resourceResponse = responseBuilder.buildPhoneResourceResponse(serviceResponse);

        return resourceResponse;
    }

    @PostMapping(value="/verify/phone/confirm" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public PhoneVerificationResourceResponse confirmPhoneVerification(@RequestBody PhoneVerificationResourceRequest request) {

    PhoneVerificationServiceRequest serviceRequest = requestBuilder.buildPhoneServiceRequest(request);

    PhoneVerificationServiceResponse serviceResponse = service.confirmPhoneVerification(serviceRequest);

    PhoneVerificationResourceResponse resourceResponse = responseBuilder.buildPhoneResourceResponse(serviceResponse);
        return resourceResponse;
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RegisterResourceResponse register(@RequestBody RegisterResourceRequest request){

        RegisterServiceRequest registerServiceRequest = requestBuilder.buildRegisterServiceRequest(request);

        RegisterServiceResponse serviceResponse = service.register(registerServiceRequest);

        RegisterResourceResponse resourceResponse = responseBuilder.buildRegisterResourceResponse(serviceResponse);

        return resourceResponse;
    }


}
