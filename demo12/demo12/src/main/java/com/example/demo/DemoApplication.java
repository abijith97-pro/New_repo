package com.example.demo;

import com.example.demo.Data.DongleRepo;
import com.example.demo.Model.Dongle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.demo.Data")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner dataLoader(DongleRepo repo) {
        repo.deleteAll();
        return args -> {
            repo.save(new Dongle("plan1","10days","190"));
            repo.save(new Dongle("plan2", "30days","299"));
            repo.save(new Dongle("plan3", "45days", "567"));

        };
    }

}
