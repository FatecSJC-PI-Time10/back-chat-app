package com.fatec.chatapp.messages;

import com.fatec.chatapp.chats.ChatsRepository;
import com.fatec.chatapp.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("messagesService")
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessagesRepository messagesRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ChatsRepository chatsRepository;

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
