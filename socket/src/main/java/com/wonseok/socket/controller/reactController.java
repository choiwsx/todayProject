package com.wonseok.socket.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class reactController {


    @GetMapping("/test")
    public HashMap hello(){
        HashMap result = new HashMap();
        result.put("message", "하이-테스트");
        return result;
    }
}
