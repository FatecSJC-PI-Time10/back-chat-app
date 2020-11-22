package com.fatec.chatapp.controllers;

import com.fatec.chatapp.dtos.MessageDTO;
import com.fatec.chatapp.services.MessagesServiceImpl;
import com.fatec.chatapp.services.ChatsServiceImpl;
import com.fatec.chatapp.models.MessageModel;
import com.fatec.chatapp.services.UsersServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Mensagens")
@RequestMapping(value = "/messages")
public class MessagesController {
    @Autowired
    MessagesServiceImpl messagesService;

    @Autowired
    ChatsServiceImpl chatsService;

    @Autowired
    UsersServiceImpl usersService;

    @PostMapping
    public MessageModel createMessage(@Valid @RequestBody MessageDTO body) {
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

