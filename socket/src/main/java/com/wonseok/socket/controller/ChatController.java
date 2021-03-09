package com.wonseok.socket.controller;


import com.wonseok.socket.domain.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessageSendingOperations;


@RequiredArgsConstructor
@Controller
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    //발행 요청 /pub/chat/message
    //구독 /sub/chat/room/{roomId}
    public void message(ChatMessage message)
    {
        if(ChatMessage.MessageType.ENTER.equals(message.getType()))
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        messagingTemplate.convertAndSend("/sub/chat/room"+message.getRoomId(), message);
    }

}
