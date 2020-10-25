package com.fatec.chatapp;

import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.chats.ChatsController;
import com.fatec.chatapp.chats.ChatsServiceImpl;
import com.fatec.chatapp.messages.MessageModel;
import com.fatec.chatapp.messages.MessagesController;
import com.fatec.chatapp.messages.MessagesRepository;
import com.fatec.chatapp.messages.MessagesServiceImpl;
import com.fatec.chatapp.users.UserModel;
import com.fatec.chatapp.users.UsersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class MessagesServiceTests {
  @MockBean
  MessagesRepository messagesRepository;

  @Autowired
  MessagesServiceImpl messagesService;

  final ChatModel chatOne = new ChatModel(UUID.randomUUID(), "ChatOne", true);
  final UserModel userOne = new UserModel(UUID.randomUUID(), "UserOne", "123123", "adawd@adwda.com", "1234567");
  final MessageModel messageOne = new MessageModel("Hello Chat", userOne, chatOne);
  final private List<MessageModel> messages = new ArrayList<>();

  @Test
  void contextLoads() throws Exception {
    assertNotNull(messagesService);
    assertNotNull(messagesRepository);
  }

  @Test
  void shouldCreateMessage() {
    given(messagesRepository.save(messageOne)).willReturn(messageOne);
    MessageModel stub = messagesService.create(messageOne);

    assertEquals(messageOne.getBody(), stub.getBody());
    assertEquals(messageOne.getChat(), stub.getChat());
    assertEquals(messageOne.getUser(), stub.getUser());
  }

  @Test
  void shouldGetAllMessages() {
    messages.add(messageOne);
    given(messagesRepository.findAll()).willReturn(messages);
    List<MessageModel> stub = messagesService.getAll();

    assertEquals(1, stub.size());
    assertEquals(messageOne, stub.get(0));
  }

  @Test
  void shouldFindOneById() {
    given(messagesRepository.findOneById(messageOne.getId())).willReturn(messageOne);
    MessageModel stub = messagesService.findOneById(messageOne.getId());

    assertEquals(messageOne.getId(), stub.getId());
    assertEquals(messageOne.getUser().getName(), stub.getUser().getName());
  }
}

@WebMvcTest(MessagesController.class)
class MessagesControllerTests {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  MessagesServiceImpl messagesService;

  @MockBean
  ChatsServiceImpl chatsService;

  @MockBean
  UsersServiceImpl usersService;

//  @Test
//  void contextLoads() throws Exception {
//    assertNotNull(mockMvc);
//    assertNotNull(messagesService);
//    assertNotNull(chatsService);
//    assertNotNull(usersService);
//  }
}
