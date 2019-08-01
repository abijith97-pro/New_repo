package com.example.demo.Data;

import com.example.demo.Model.Registration;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Registrationrepo extends MongoRepository<Registration,String> {
}
