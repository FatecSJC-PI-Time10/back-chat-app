package com.fatec.chatapp.repositories;

import com.fatec.chatapp.models.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessagesRepository extends JpaRepository<MessageModel, Long> {
    MessageModel findOneById(UUID uuid);
}
