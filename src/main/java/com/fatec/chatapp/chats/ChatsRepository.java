package com.fatec.chatapp.chats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatsRepository extends JpaRepository<ChatModel, Long> {

}
