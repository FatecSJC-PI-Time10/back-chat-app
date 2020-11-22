package com.fatec.chatapp.services;

import com.fatec.chatapp.models.ChatModel;

import java.util.List;
import java.util.UUID;

public interface ChatsService {
     ChatModel create(ChatModel c);
     List<ChatModel> getAll();
     ChatModel findOneById(UUID id);
     Boolean delete(UUID id);
}
