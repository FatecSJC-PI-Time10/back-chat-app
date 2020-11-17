package com.fatec.chatapp.chats;

import java.util.List;
import java.util.UUID;

public interface ChatsService {
     ChatModel create(ChatDTO body);
     List<ChatModel> getAll();
     ChatModel findOneById(UUID id);
}
