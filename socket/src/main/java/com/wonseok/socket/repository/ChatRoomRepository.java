package com.wonseok.socket.repository;

import com.wonseok.socket.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {

}
