package com.example.demo.Data;


import com.example.demo.model.PrepaidPlan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrepaidPlanRepo extends MongoRepository<PrepaidPlan,String> {
}
