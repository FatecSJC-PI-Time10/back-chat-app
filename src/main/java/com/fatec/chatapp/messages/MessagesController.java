package com.fatec.chatapp.messages;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Mensagens")
@RequestMapping(value = "/messages")
public class MessagesController {
    @Autowired
    MessagesServiceImpl messagesService;

    @PostMapping
    public MessageModel createMessage(@RequestBody MessageDTO body) {
        return messagesService.create(body);
    }

    @GetMapping
    public List<MessageModel> getAllMessages() {
        return messagesService.getAll();
    }

    @GetMapping("/{id}")
    public MessageModel getMessageById(@PathVariable UUID id) {
        return messagesService.findOneById(id);
    }
}

