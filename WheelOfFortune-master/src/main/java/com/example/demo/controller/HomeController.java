package com.example.demo.controller;

import com.example.demo.domain.Fortune;
import com.example.demo.exception.FortuneNotFoundException;
import com.example.demo.service.FortuneService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

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

    @PutMapping("/fortunes")
    public void addFortune(@RequestBody Fortune fortune) {
        fortuneService.addFortune(fortune);
    }

    @DeleteMapping("/fortunes")
    public void deleteFortune(@RequestBody Long id)
    {

    }


    @GetMapping("/fortune")
    Fortune randomOne() throws FortuneNotFoundException {
        return fortuneService.getRandom().orElseThrow(() -> new FortuneNotFoundException());
    }

}
