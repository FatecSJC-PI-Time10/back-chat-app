package com.fatec.chatapp.controllers;


import com.fatec.chatapp.dtos.MessageDTO;
import com.fatec.chatapp.models.MessageModel;
import com.fatec.chatapp.services.ChatsServiceImpl;
import com.fatec.chatapp.dtos.ChatDTO;
import com.fatec.chatapp.models.ChatModel;
import com.fatec.chatapp.services.MessagesServiceImpl;
import com.fatec.chatapp.services.UsersServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Chats")
@RestController
@RequestMapping(value = "/chats")
public class ChatsController {
  @Autowired
  private ChatsServiceImpl chatsService;

  @Autowired
  private UsersServiceImpl usersService;

  @Autowired
  private MessagesServiceImpl messagesService;

  @Autowired
  private SimpMessagingTemplate messagingTemplate;

  @Autowired
  public ChatsServiceImpl chatService;

  @PostMapping
  public ChatModel createChat(@Valid @RequestBody ChatDTO body) {
    final ChatModel model = new ChatModel(body.getName(), body.getISActive());
    return chatService.create(model);
  }

  @GetMapping
  public List<ChatModel> getAllChats() {
    return chatService.getAll();
  }

  @MessageMapping("chat")
  public void processMessage(@Payload MessageDTO body) {
    final MessageModel message = messagesService.create(body);

    messagingTemplate.convertAndSendToUser(
            body.getChatId().toString(), "/queue/messages",
            message);
  }
}
