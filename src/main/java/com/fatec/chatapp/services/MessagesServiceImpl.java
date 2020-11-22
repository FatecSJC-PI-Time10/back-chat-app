package com.fatec.chatapp.services;

import com.fatec.chatapp.dtos.MessageDTO;
import com.fatec.chatapp.models.ChatModel;
import com.fatec.chatapp.models.UserModel;
import com.fatec.chatapp.repositories.ChatsRepository;
import com.fatec.chatapp.models.MessageModel;
import com.fatec.chatapp.repositories.MessagesRepository;
import com.fatec.chatapp.repositories.UsersRepository;
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
    public MessageModel create(MessageDTO m) {
        final UserModel user = usersRepository.findOneById(m.getUserId());

        final ChatModel chat = chatsRepository.findOneById(m.getChatId());

        final MessageModel message = new MessageModel(m.getBody(), user, chat);

        return messagesRepository.save(message);
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
