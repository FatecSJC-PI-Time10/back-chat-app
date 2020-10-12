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

import static org.assertj.core.api.Assertions.assertThat;
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
  private ChatsRepository chatsRepository;

  @Autowired
  private ChatsServiceImpl chatService;

  final List<ChatModel> chats = new ArrayList<>();
  final ChatModel chatOne = new ChatModel(UUID.randomUUID(), "String", true);

  @Test
  public void contextLoads() throws Exception {
    assertThat(chatService).isNotNull();
  }

  @Test
  public void shouldCreateChat() throws Exception {
    given(chatsRepository.save(chatOne)).willReturn(chatOne);
    ChatModel stub = chatService.create(chatOne);

    assertEquals(chatOne.getId(), stub.getId());
    assertEquals(chatOne.getIsActive(), stub.getIsActive());
  }

  @Ignore
  @Test
  public void shouldGetAllChats() throws Exception {
    chats.add(chatOne);
    given(chatsRepository.findAll()).willReturn(chats);

    List<ChatModel> stub = chatService.getAll();

    assertEquals(1, stub.size());
  }
}

@WebMvcTest(ChatsController.class)
class ChatsControllerTests {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ChatsServiceImpl chatsService;

  final List<ChatModel> chats = new ArrayList<>();
  final ChatModel chatOne = new ChatModel(UUID.randomUUID(), "Chat One", true);

  @Test
  public void shouldFetchAll() throws Exception {
    when(chatsService.getAll()).thenReturn(chats);
    this.mockMvc.perform(get("/chats")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void shouldCreate() throws Exception {
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

