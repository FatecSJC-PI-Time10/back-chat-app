package com.fatec.chatapp.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messages")
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessagesRepository messagesRepository;

    @Override
    public MessageModel createMessage(MessageModel m) {
        return messagesRepository.save(m);
    }

    @Override
    public List<MessageModel> getAllMessages() {
        return messagesRepository.findAll();
    }
}
