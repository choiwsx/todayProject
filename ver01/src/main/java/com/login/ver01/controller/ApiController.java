package com.login.ver01.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ApiController {

    @GetMapping("/api/hello")
    public HashMap hello(){
        HashMap result = new HashMap();
        result.put("message", "안녕하세요");
        return result;
    }

    @GetMapping("/api/ip")
    public ResponseEntity<String> ip(HttpServletRequest request){
        System.out.println(request.getRemoteAddr());
        return ResponseEntity.ok(request.getRemoteAddr());
    }

}
