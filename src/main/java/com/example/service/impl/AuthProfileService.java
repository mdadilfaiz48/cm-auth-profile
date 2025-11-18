package com.example.service.impl;

import com.example.beans.request.EmailVerificationDAORequest;
import com.example.beans.request.EmailVerificationServiceRequest;
import com.example.beans.request.PhoneVerificationServiceRequest;
import com.example.beans.response.EmailVerificationServiceResponse;
import com.example.beans.response.PhoneVerificationDAOResponse;
import com.example.beans.response.PhoneVerificationServiceResponse;
import com.example.builder.request.AuthProfileRequestBuilder;
import com.example.builder.response.AuthProfileResponseBuilder;
import com.example.dao.AuthProfileDAO;
import com.example.entity.VerificationEntity;
import com.example.service.IAuthProfileService;
import com.example.utils.AuthProfileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthProfileService implements IAuthProfileService {
    private static final String OTP_VALID_MESSAGE = "OTP already sent to this email and valid till :";
    public static final String EMAIL_VARIFICATION_AGAIN= "OTP expired. Please initiate email verification again.";
    public static final String EMAIL_VERIFIED_SUCCESS_MSG = "Email verified successfully.";
    private static final String OTP_EXPIRY_AND_NEW_OTP_MSG = "New OTP sent and valid for 5 minutes till :";
    private static final String EMAIL_VERIFICATION_FAILED_MSG = "Failed to initiate email verification.";
    private static final String EMAIL_ALREADY_VERIFIED_MSG_PREFIX = "Email verification initiated. please check your email and valid for ";
    private static final String EMAIL_ALREADY_VERIFIED_MSG_SUFFIX = " minutes till :";
    public static final String MOBILE_OTP_EXPIRY_AND_NEW_OTP_MSG = "OTP already sent to this mobile number and valid till :";
    private static final String MOBILE_ALREADY_VERIFIED_MSG_PREFIX = "Phone verification initiated. please check your mobile and valid for ";
    private static final String MOBILE_ALREADY_VERIFIED_MSG_SUFFIX = " minutes till :";
    private static final String  MOBILE_VARIFICATION_AGAIN = "OTP expired. Please initiate phone verification again.";
    public static final String MOBILE_VERIFIED_SUCCESS_MSG = "Phone verified successfully.";


    @Value("${otp.expiration.minutes}")
    private Integer otpExpiryMinutes;

    @Autowired
    private AuthProfileDAO dao;


    @Override
    public EmailVerificationServiceResponse initEmailVerification(EmailVerificationServiceRequest serviceRequest) {

        EmailVerificationServiceResponse serviceResponse = new EmailVerificationServiceResponse();

        // dao.findByEmailId("khan56@gmail.com")
        VerificationEntity existingEntity = dao.findByEmailId(serviceRequest.getEmailId());


        // Checking if existing OTP is still valid
        if (existingEntity != null) {
            if(existingEntity.isEmailVerified())
            {
                serviceResponse.setMessage("Email is already verified.");
                return serviceResponse;
            }

            if (existingEntity.getEmailOtpExpireTime().isAfter(LocalDateTime.now())) {
                serviceResponse.setMessage(OTP_VALID_MESSAGE + existingEntity.getEmailOtpExpireTime());
                return serviceResponse;
            }
            if (existingEntity.getEmailOtpExpireTime().isBefore(LocalDateTime.now())) {
                String otp = AuthProfileUtils.generateOtp();
                LocalDateTime expireTime = LocalDateTime.now().plusMinutes(otpExpiryMinutes);
                existingEntity.setEmailOtp(otp);
                existingEntity.setEmailOtpExpireTime(expireTime);
                dao.save(existingEntity);
                // todo: send this OTP to notification service to send email
                serviceResponse.setMessage(OTP_EXPIRY_AND_NEW_OTP_MSG + expireTime);
                return serviceResponse;
            }
        }

        VerificationEntity entity = new VerificationEntity();
        if (existingEntity == null) {

            // Generate new OTP first time
            entity.setId(AuthProfileUtils.generateVerificationId());
            entity.setEmailId(serviceRequest.getEmailId());
            entity.setEmailOtp(AuthProfileUtils.generateOtp());
            LocalDateTime expireTime = LocalDateTime.now().plusMinutes(otpExpiryMinutes);
            entity.setEmailOtpExpireTime(expireTime);
            VerificationEntity response = dao.save(entity);
            // send this OTP to notification service to send email
            // Here
            if (response != null) {
                serviceResponse.setMessage(EMAIL_ALREADY_VERIFIED_MSG_PREFIX + otpExpiryMinutes + EMAIL_ALREADY_VERIFIED_MSG_SUFFIX + expireTime);
            } else {
                serviceResponse.setMessage(EMAIL_VERIFICATION_FAILED_MSG);
            }
        }


        return serviceResponse;
    }

    @Override
    public EmailVerificationServiceResponse confirmEmailVerification(EmailVerificationServiceRequest serviceRequest) {

        VerificationEntity existingEntity = dao.findByEmailId(serviceRequest.getEmailId());
        EmailVerificationServiceResponse serviceResponse = new EmailVerificationServiceResponse();

        if (existingEntity != null) {
            if (existingEntity.getEmailOtpExpireTime().isBefore(LocalDateTime.now())) {
                serviceResponse.setMessage(EMAIL_VARIFICATION_AGAIN);
            } else {
                existingEntity.setEmailVerified(true);
                dao.save(existingEntity);
                serviceResponse.setMessage(EMAIL_VERIFIED_SUCCESS_MSG);
            }
        }
        System.out.println("AuthProfileService.confirmEmailVerification====================================>" + serviceResponse);
        return serviceResponse;
    }

    @Override
    public PhoneVerificationServiceResponse initPhoneVerification(PhoneVerificationServiceRequest serviceRequest) {
        PhoneVerificationServiceResponse serviceResponse = new PhoneVerificationServiceResponse();

        VerificationEntity existingEntity = dao.findByEmailId(serviceRequest.getEmailId());
        if (!existingEntity.isEmailVerified()) {
            serviceResponse.setMessage(MOBILE_OTP_EXPIRY_AND_NEW_OTP_MSG);
            return serviceResponse;
        }


        if (existingEntity.getMobile() != null && existingEntity.getMobile().equals(serviceRequest.getMobileNo())) {
                if(existingEntity.isMobileVerified())
                {
                    serviceResponse.setMessage("Mobile number is already verified.");
                    return serviceResponse;
                }
            if (existingEntity.getMobileOtpExpireTime().isAfter(LocalDateTime.now())) {
                serviceResponse.setMessage(MOBILE_OTP_EXPIRY_AND_NEW_OTP_MSG + existingEntity.getMobileOtpExpireTime());
                return serviceResponse;
            }
            if (existingEntity.getMobileOtpExpireTime().isBefore(LocalDateTime.now())) {
                String otp = AuthProfileUtils.generateOtp();
                LocalDateTime expireTime = LocalDateTime.now().plusMinutes(otpExpiryMinutes);
                existingEntity.setMobileOtp(otp);
                existingEntity.setMobileOtpExpireTime(expireTime);
                dao.save(existingEntity);
                // todo: send this OTP to notification service to send SMS

            }
        }


            // email,
            existingEntity.setMobile(serviceRequest.getMobileNo());
            existingEntity.setMobileOtp(AuthProfileUtils.generateOtp());
            existingEntity.setMobileOtpExpireTime(LocalDateTime.now().plusMinutes(otpExpiryMinutes));
            dao.save(existingEntity);
            // todo: send this OTP to notification service to send SMS
            serviceResponse.setMessage(MOBILE_ALREADY_VERIFIED_MSG_PREFIX + otpExpiryMinutes + MOBILE_ALREADY_VERIFIED_MSG_SUFFIX + existingEntity.getMobileOtpExpireTime());
            return serviceResponse;
        }

    @Override
    public PhoneVerificationServiceResponse confirmPhoneVerification(PhoneVerificationServiceRequest serviceRequest) {
        PhoneVerificationServiceResponse serviceResponse = new PhoneVerificationServiceResponse();
        VerificationEntity existingEntity = dao.findByEmailIdAndMobile(serviceRequest.getEmailId(),serviceRequest.getMobileNo());

           if(existingEntity != null){
                if(existingEntity.getMobileOtpExpireTime().isBefore(LocalDateTime.now())){
                     serviceResponse.setMessage(MOBILE_VARIFICATION_AGAIN );
                } else {
                     existingEntity.setMobileVerified(true);
                     existingEntity.setVerificationCompleted(true);
                     dao.save(existingEntity);
                     serviceResponse.setMessage(MOBILE_VERIFIED_SUCCESS_MSG);
                }

                return serviceResponse;
           }
        return serviceResponse;
    }


}
