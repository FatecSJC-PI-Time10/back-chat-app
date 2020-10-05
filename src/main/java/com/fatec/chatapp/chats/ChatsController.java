package com.fatec.chatapp.chats;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatsController {

    @Autowired
    ChatsServiceImpl chatService;

    @PostMapping("/chats")
    public ChatModel createChat(@RequestBody ChatModel body){
        return chatService.createChat(body);
    }

    @GetMapping("/chats")
    public List<ChatModel> getAllChats(){
        return chatService.getAllChats();
    }


}
