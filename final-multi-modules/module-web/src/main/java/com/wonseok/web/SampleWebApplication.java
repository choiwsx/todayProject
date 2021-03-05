package com.wonseok.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.wonseok"}, exclude = {JpaRepositoriesAutoConfiguration.class})
//@EntityScan("com.wonseok.*")
//@EnableJpaRepositories("com.wonseok.*")
public class SampleWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleWebApplication.class, args);
    }
}
