package com.fatec.chatapp.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagesController {
    @Autowired
    MessagesServiceImpl messagesService;

    @PostMapping("/messages")
    MessageModule createMessage(@RequestBody MessageModule body) {
        return messagesService.createMessage(body);
    }
}
