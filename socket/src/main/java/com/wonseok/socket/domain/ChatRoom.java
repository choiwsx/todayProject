package com.wonseok.socket.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Entity
public class ChatRoom {

    @Id
    private String roomId;

    private String name;





    public static ChatRoom create(String name)
    {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }


}
