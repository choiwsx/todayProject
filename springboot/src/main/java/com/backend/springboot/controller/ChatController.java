package com.backend.springboot.controller;


import com.backend.springboot.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ChatController {


    @MessageMapping("/user-all")
    @SendTo("/topic/user")
    public ChatMessage send(@Payload ChatMessage chatMessage)
    {
        return chatMessage;
    }
}
