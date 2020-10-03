package com.fatec.chatapp.messages;

import java.util.List;

public interface MessagesService {
    MessageModule createMessage(MessageModule m);
    List<MessageModule> getAllMessages();
}
