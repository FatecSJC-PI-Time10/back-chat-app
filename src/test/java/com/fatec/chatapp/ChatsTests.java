package com.fatec.chatapp;

import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.chats.ChatsController;
import com.fatec.chatapp.chats.ChatsRepository;
import com.fatec.chatapp.chats.ChatsServiceImpl;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class ChatsServiceTests {
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

  @Ignore
  @Test
  void shouldGetAllChats() throws Exception {
    chats.add(chatOne);
    given(chatsRepository.findAll()).willReturn(chats);

    List<ChatModel> stub = chatsService.getAll();

    assertEquals(1, stub.size());
  }
}

@WebMvcTest(ChatsController.class)
class ChatsControllerTests {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  ChatsServiceImpl chatsService;

  final List<ChatModel> chats = new ArrayList<>();
  final ChatModel chatOne = new ChatModel(UUID.randomUUID(), "Chat One", true);

  @Test
  void contextLoads() throws Exception {
    assertNotNull(mockMvc);
    assertNotNull(chatsService);
  }

  @Test
  void shouldFetchAll() throws Exception {
    when(chatsService.getAll()).thenReturn(chats);
    this.mockMvc.perform(get("/chats")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  void shouldCreate() throws Exception {
    final String json = chatOne.toJson();
    assertNotNull(json);
    when(chatsService.create(chatOne)).thenReturn(chatOne);
    this.mockMvc.perform(post("/chats")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andDo(print())
            .andExpect(status().isOk());
  }
}

