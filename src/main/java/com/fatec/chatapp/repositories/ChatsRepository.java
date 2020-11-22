package com.fatec.chatapp.chats;

import com.fatec.chatapp.models.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatsRepository extends JpaRepository<ChatModel, Long> {
    ChatModel findOneById(UUID id);
}
