package com.fatec.chatapp.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagesController {
    @Autowired
    MessagesServiceImpl messagesService;

    @PostMapping("/messages")
    MessageModule createMessage(@RequestBody MessageModule body) {
        return messagesService.createMessage(body);
    }

    @GetMapping("/messages")
    List<MessageModule> getAllMessages() {
        return messagesService.getAllMessages();
    }
}
