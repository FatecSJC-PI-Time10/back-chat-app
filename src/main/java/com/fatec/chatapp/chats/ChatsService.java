package com.fatec.chatapp.chats;

import java.util.List;
import java.util.UUID;

public interface ChatsService {
     ChatModel create(ChatModel c);
     List<ChatModel> getAll();
     ChatModel findOneById(UUID id);
}
