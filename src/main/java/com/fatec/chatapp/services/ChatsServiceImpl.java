package com.fatec.chatapp.services;

import com.fatec.chatapp.models.ChatModel;
import com.fatec.chatapp.repositories.ChatsRepository;
import com.fatec.chatapp.services.ChatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("chats")
public class ChatsServiceImpl implements ChatsService {

  @Autowired
  private ChatsRepository chatsRepository;

  @Override
  public ChatModel create(ChatModel c) {
    return chatsRepository.save(c);
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
