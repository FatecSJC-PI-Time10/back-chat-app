package com.fatec.chatapp.messages;

import java.util.List;

public interface MessagesService {
    MessageModel createMessage(MessageModel m);
    List<MessageModel> getAllMessages();
}
