package com.example.demo;

import com.example.demo.Data.PostRepo;
import com.example.demo.Model.PostPaid;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.demo.Data")
public class MiniprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniprojectApplication.class, args);
    }
    @Bean
    public CommandLineRunner dataLoader(PostRepo repo) {
        return args -> {
            repo.save(new PostPaid("plan1","10days","190"));
            repo.save(new PostPaid("plan2", "30days","299"));
            repo.save(new PostPaid("plan3", "45days", "567"));

        };
    }

}
