package com.example.demo.Data;
import com.example.demo.Model.Register1;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserCredentialsRepository extends MongoRepository<Register1, String> {
    List<Register1> findByFull_nameAndPassword(String full_name,String password);
}
