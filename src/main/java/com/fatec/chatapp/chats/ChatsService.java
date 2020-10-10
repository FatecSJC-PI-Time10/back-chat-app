package com.fatec.chatapp.chats;

import java.util.List;

public interface ChatsService {
    public ChatModel create(ChatModel body);
    public List<ChatModel> getAll();
    public ChatModel findOneById();
}
