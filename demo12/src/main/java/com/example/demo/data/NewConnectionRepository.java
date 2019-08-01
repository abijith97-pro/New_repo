package com.example.demo.data;


import com.example.demo.model.RegistrationForm;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface NewConnectionRepository extends MongoRepository <RegistrationForm,String>
{



}
