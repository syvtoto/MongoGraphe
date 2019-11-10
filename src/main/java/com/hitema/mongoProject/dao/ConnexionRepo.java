package com.hitema.mongoProject.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hitema.mongoProject.model.Connexion;

public interface ConnexionRepo extends MongoRepository<Connexion, String>{

}
