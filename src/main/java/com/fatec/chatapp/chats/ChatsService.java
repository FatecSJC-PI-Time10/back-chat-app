package com.fatec.chatapp.chats;

import java.util.List;

public interface ChatsService {
    public ChatModel createChat(ChatModel body);
    public List<ChatModel> getAllChats();
    public ChatModel getChatById();
}
