package com.fatec.chatapp.chats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chats")
public class ChatsServiceImpl implements ChatsService {

    @Autowired
    private ChatsRepository chatsRepository;

    @Override
    public ChatModel createChat(ChatModel body) {

        return chatsRepository.save(body);
    }

    @Override
    public List<ChatModel> getAllChats() {
        return chatsRepository.findAll();
    }

    @Override
    public ChatModel getChatById() {
        return null;
    }
}
