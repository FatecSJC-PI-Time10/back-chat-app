package com.fatec.chatapp.chats;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Chats")
@RestController
@RequestMapping(value = "/chats")
public class ChatsController {

    @Autowired
    public ChatsServiceImpl chatService;

    @PostMapping
    public ChatModel createChat(@Valid @RequestBody ChatModel body){
        return chatService.create(body);
    }

    @GetMapping
    public List<ChatModel> getAllChats(){
        return chatService.getAll();
    }
}
