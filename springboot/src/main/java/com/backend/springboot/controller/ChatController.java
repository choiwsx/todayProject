package com.backend.springboot.controller;


import com.backend.springboot.model.ChatMessage;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/user-all")
    @SendTo("/topic/user")
    public ChatMessage send(@Payload ChatMessage chatMessage)
    {
        return chatMessage;
    }

    @MessageMapping("/room/{room}") //리액트에서 SENDMESSAGE랑 연결되는것 같음
    public void test(@DestinationVariable String room,  @Payload ChatMessage chatMessage) throws Exception
    {
        //여기서 /topic/room/{roomId}는 리액트에서  SockJSClient연결할떄 토픽 정해주는데 거기 토픽으로 보낸다는것 같음.
        this.template.convertAndSend("/topic/room/"+room, chatMessage );
    }
}
