package com.example.dao;

import com.example.entity.UserProfileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserProfileDAO extends MongoRepository<UserProfileEntity, String> {
}
