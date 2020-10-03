package com.fatec.chatapp.chats;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    ChatServiceImpl chatService;

    @PostMapping("/chat")
    public ChatModule createChat(@RequestBody ChatModule body){
        return chatService.createChat(body);
    }



    @GetMapping("/chat")
    public ChatModule getChat(){
        return chatService.getChatById();

    }


}
