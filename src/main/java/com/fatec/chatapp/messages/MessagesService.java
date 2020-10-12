package com.fatec.chatapp.messages;

import java.util.List;
import java.util.UUID;

public interface MessagesService {
    MessageModel create(MessageModel m);
    List<MessageModel> getAll();
    MessageModel findOneById(UUID id);
}
