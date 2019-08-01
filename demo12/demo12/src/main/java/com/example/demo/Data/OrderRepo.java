package com.example.demo.Data;

import com.example.demo.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<Order,String> {
}
