package com.example.dao;

import com.example.entity.VerificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthVerificationDAO extends MongoRepository <VerificationEntity, String> {

    public VerificationEntity findByEmailId(String emailId);

    public VerificationEntity findByMobile(String mobile);

    public VerificationEntity findByEmailIdAndMobile(String emailId, String mobile);

}
