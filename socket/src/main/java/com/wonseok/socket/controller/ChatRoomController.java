package com.wonseok.socket.controller;


import com.wonseok.socket.domain.ChatRoom;
import com.wonseok.socket.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {

    private ChatRoomRepository chatRoomRepository;

    // 채팅 리스트
    @GetMapping("/room")
    public String rooms()
    {
        return "/chat/room";
    }

    //모든 채팅방
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room(){
        return chatRoomRepository.findAll();
    }

    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name)
    {
        ChatRoom chatRoom = ChatRoom.create(name);
        return chatRoomRepository.save(chatRoom);
    }




}
