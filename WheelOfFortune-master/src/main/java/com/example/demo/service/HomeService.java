package com.example.demo.service;


import com.example.demo.repository.FortuneRepository;
import org.springframework.stereotype.Component;

@Component
public class HomeService {

    private FortuneRepository fortuneRepository;

    public HomeService(FortuneRepository fortuneRepository){
        this.fortuneRepository = fortuneRepository;
    }

}
