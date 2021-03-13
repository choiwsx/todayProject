package com.backend.springboot.controller;


import com.backend.springboot.model.User;
import com.backend.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("user")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
