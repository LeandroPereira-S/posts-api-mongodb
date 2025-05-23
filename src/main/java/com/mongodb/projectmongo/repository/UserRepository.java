package com.mongodb.projectmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.projectmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
