package com.backend.springboot;

import com.backend.springboot.model.User;
import com.backend.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }


    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        this.userRepository.save(new User("wonseok","wonseok@naver.com"));
        this.userRepository.save(new User("wonseok2","wonseok2@naver.com"));
        this.userRepository.save(new User("wonseok3","wonseok3@naver.com"));

    }
}
