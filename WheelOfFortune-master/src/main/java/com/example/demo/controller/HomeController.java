package com.example.demo.controller;

import com.example.demo.domain.Fortune;
import com.example.demo.exception.FortuneNotFoundException;
import com.example.demo.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private final FortuneService fortuneService;

    @Autowired
    public HomeController(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @GetMapping("/fortunes")
    List<Fortune> getAll() throws FortuneNotFoundException {
        return fortuneService.getAll();
    }


    @GetMapping("/fortune")
    Fortune randomOne() throws FortuneNotFoundException {
        return fortuneService.getRandom().orElseThrow(() -> new FortuneNotFoundException());
    }

}
