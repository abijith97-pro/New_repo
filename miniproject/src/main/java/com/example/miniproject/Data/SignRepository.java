package com.example.demo.repository;
import com.example.demo.model.Register1;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCredentialsRepository extends MongoRepository<Register1, String> {
}
