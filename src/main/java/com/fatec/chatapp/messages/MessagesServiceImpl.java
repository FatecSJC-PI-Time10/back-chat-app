package com.fatec.chatapp.messages;

import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.chats.ChatsRepository;
import com.fatec.chatapp.users.UserModel;
import com.fatec.chatapp.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("messages")
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessagesRepository messagesRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ChatsRepository chatsRepository;

    @Override
    public MessageModel create(MessageDTO m) {
        final UserModel userModel = usersRepository.findOneById(m.getUserId());
        final ChatModel chatModel = chatsRepository.findOneById(m.getChatId());
        final MessageModel model = new MessageModel(m.getBody(), userModel, chatModel);

        return messagesRepository.save(model);
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
