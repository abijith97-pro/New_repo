package com.example.demo.Data;

import com.example.demo.Model.PostPaid;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<PostPaid,String> {
}
