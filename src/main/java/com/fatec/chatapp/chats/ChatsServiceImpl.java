package com.fatec.chatapp.chats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chats")
public class ChatsServiceImpl implements ChatsService {

    @Autowired
    private ChatsRepository chatsRepository;

    @Override
    public ChatModel create(ChatModel body) {

        return chatsRepository.save(body);
    }

    @Override
    public List<ChatModel> getAll() {
        return chatsRepository.findAll();
    }

    @Override
    public ChatModel findOneById() {
        return null;
    }
}
