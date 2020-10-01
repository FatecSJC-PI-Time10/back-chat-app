package com.fatec.chatapp.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("Messages Service")
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessagesRepository messagesRepository;

    @Override
    public MessageModule createMessage(MessageModule m) {
        return messagesRepository.save(m);
    }

    @Override
    public List<MessageModule> getAllMessages() {
        return messagesRepository.findAll();
    }
}
