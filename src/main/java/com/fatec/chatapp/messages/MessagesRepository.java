package com.fatec.chatapp.messages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessagesRepository extends JpaRepository<MessageModel, Long> {
    MessageModel findOneById(UUID uuid);
}
