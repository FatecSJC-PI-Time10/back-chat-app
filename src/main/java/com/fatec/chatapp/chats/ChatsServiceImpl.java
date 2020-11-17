package com.fatec.chatapp.chats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("chats")
public class ChatsServiceImpl implements ChatsService {

    @Autowired
    private ChatsRepository chatsRepository;

    @Override
    public ChatModel create(ChatDTO body) {
        final ChatModel model = new ChatModel(body.getName(), body.getISActive());
        return chatsRepository.save(model);
    }

    @Override
    public List<ChatModel> getAll() {
        return chatsRepository.findAll();
    }

    @Override
    public ChatModel findOneById(UUID id) {
        return chatsRepository.findOneById(id);
    }
}
