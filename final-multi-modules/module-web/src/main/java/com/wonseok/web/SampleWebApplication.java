package com.wonseok.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"com.wonseok"}, exclude = {JpaRepositoriesAutoConfiguration.class})
//@EntityScan("com.wonseok.*")
//@EnableJpaRepositories("com.wonseok.*")
public class SampleWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleWebApplication.class, args);
    }
}
