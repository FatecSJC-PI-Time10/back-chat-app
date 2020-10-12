package com.fatec.chatapp.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MessagesController {
    @Autowired
    MessagesServiceImpl messagesService;

    @PostMapping("/messages")
    public MessageModel createMessage(@RequestBody MessageDTO body) {
        return messagesService.create(body);
    }

    @GetMapping("/messages")
    public List<MessageModel> getAllMessages() {
        return messagesService.getAll();
    }

    @GetMapping("/messages/{id}")
    public MessageModel getMessageById(@PathVariable UUID id) {
        return messagesService.findOneById(id);
    }
}

