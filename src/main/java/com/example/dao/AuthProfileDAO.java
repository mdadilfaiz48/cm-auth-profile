package com.example.dao;

import com.example.beans.request.EmailVerificationDAORequest;
import com.example.beans.response.EmailVerificationDAOResponse;
import com.example.entity.VerificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthProfileDAO extends MongoRepository <VerificationEntity, String> {

    public VerificationEntity findByEmailId(String emailId);

    public VerificationEntity findByMobile(String mobile);

}
