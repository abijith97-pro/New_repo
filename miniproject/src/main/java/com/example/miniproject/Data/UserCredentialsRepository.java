package com.example.demo.data;

import com.example.demo.model.Prepaid;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserCredentialsRepository extends MongoRepository<Prepaid,String> {
}
