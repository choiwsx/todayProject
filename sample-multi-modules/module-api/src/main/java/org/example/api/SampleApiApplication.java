package org.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.example.*")
@EnableJpaRepositories("org.example.*")
public class SampleApiApplication{

    public static void main(String[] args){
        SpringApplication.run(SampleApiApplication.class, args);
    }
}