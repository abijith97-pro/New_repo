package com.example.demo.Data;

import com.example.demo.Model.Dongle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DongleRepo extends MongoRepository<Dongle,String> {
}
