package com.fatec.chatapp.messages;

import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.chats.ChatsServiceImpl;
import com.fatec.chatapp.users.UserModel;
import com.fatec.chatapp.users.UsersServiceImpl;
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
    public MessageModel createMessage(@Valid @RequestBody MessageDTO request) {
        final UserModel userModel = usersService.findOneById(request.getUserId());
        final ChatModel chatModel = chatsService.findOneById(request.getChatId());
        final MessageModel model = new MessageModel(request.getBody(), userModel, chatModel);

        return messagesService.create(model);
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

