package com.fatec.chatapp.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("messages")
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessagesRepository messagesRepository;

    @Override
    public MessageModel create(MessageModel m) {
        return messagesRepository.save(m);
    }

    @Override
    public List<MessageModel> getAll() {
        return messagesRepository.findAll();
    }

    @Override
    public MessageModel findOneById(UUID id) {
        return messagesRepository.findOneById(id);
    }
}
