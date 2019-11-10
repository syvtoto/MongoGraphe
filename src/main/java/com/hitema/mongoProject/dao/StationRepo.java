package com.hitema.mongoProject.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hitema.mongoProject.model.Station;

public interface StationRepo extends MongoRepository<Station, String>{
}
