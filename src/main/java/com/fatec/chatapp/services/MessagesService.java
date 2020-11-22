package com.fatec.chatapp.services;

import com.fatec.chatapp.dtos.MessageDTO;
import com.fatec.chatapp.models.MessageModel;

import java.util.List;
import java.util.UUID;

public interface MessagesService {
    MessageModel create(MessageDTO m);
    List<MessageModel> getAll();
    MessageModel findOneById(UUID id);
}
