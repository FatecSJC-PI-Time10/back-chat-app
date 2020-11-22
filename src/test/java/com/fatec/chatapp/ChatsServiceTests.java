package com.fatec.chatapp;

import com.fatec.chatapp.models.ChatModel;
import com.fatec.chatapp.repositories.ChatsRepository;
import com.fatec.chatapp.services.ChatsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatsServiceTests {
  @MockBean
  ChatsRepository chatsRepository;

  @Autowired
  ChatsServiceImpl chatsService;

  final List<ChatModel> chats = new ArrayList<>();
  final ChatModel chatOne = new ChatModel(UUID.randomUUID(), "String", true);

  @Test
  void contextLoads() throws Exception {
    assertNotNull(chatsRepository);
    assertNotNull(chatsService);
  }

  @Test
  void shouldCreateChat() throws Exception {
    given(chatsRepository.save(chatOne)).willReturn(chatOne);
    ChatModel stub = chatsService.create(chatOne);

    assertEquals(chatOne.getId(), stub.getId());
    assertEquals(chatOne.getIsActive(), stub.getIsActive());
  }

  @Test
  void shouldGetAllChats() throws Exception {
    chats.add(chatOne);
    given(chatsRepository.findAll()).willReturn(chats);

    List<ChatModel> stub = chatsService.getAll();

    assertEquals(1, stub.size());
  }
}

