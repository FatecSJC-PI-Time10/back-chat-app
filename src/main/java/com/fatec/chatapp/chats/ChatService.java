package com.fatec.chatapp.chats;

public interface ChatService {
    public ChatModule createChat(ChatModule body);
    public void getAllChats();
    public ChatModule getChatById();
}
