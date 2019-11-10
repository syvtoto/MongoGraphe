package com.hitema.mongoProject.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hitema.mongoProject.model.Station;
import com.hitema.mongoProject.model.User;

public interface UserRepo extends MongoRepository<User, String>{

}
