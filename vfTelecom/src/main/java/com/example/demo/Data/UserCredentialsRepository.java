package com.example.demo.Data;

import com.example.demo.Model.Prepaid;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserCredentialsRepository extends MongoRepository<Prepaid,String> {
}
