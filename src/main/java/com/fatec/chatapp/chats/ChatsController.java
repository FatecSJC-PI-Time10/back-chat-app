package com.fatec.chatapp.chats;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chats")
public class ChatsController {

    @Autowired
    public ChatsServiceImpl chatService;

    @PostMapping
    public ChatModel createChat(@RequestBody ChatModel body){
        return chatService.create(body);
    }

    @GetMapping
    public List<ChatModel> getAllChats(){
        return chatService.getAll();
    }
}
