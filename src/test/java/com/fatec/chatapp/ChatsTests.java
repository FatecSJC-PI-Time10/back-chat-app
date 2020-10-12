package com.fatec.chatapp;

import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.chats.ChatsRepository;
import com.fatec.chatapp.chats.ChatsServiceImpl;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatsTests {
    @MockBean
    private ChatsRepository chatsRepository;

    @Autowired
    private ChatsServiceImpl chatService;

    final List<ChatModel> chats = new ArrayList<>();
    final ChatModel chatOne = new ChatModel(UUID.randomUUID(),"String",true);

    @Ignore
    @Test
    public void contextLoads() throws Exception {
        chats.add(chatOne);

        given(chatsRepository.findAll()).willReturn(chats);
        given(chatsRepository.save(chatOne)).willReturn(chatOne);

        assertThat(chatService).isNotNull();
    }

    @Ignore
    @Test
    public void shouldCreateChat() throws  Exception{
        ChatModel stub = chatService.create(chatOne);

        assertEquals(chatOne.getId(), stub.getId());
        assertEquals(chatOne.getIsActive(), stub.getIsActive());
    }

    @Ignore
    @Test
    public void shouldGetAllChats() throws Exception{
        List<ChatModel> stub = chatService.getAll();

        assertEquals(1, stub.size());
    }
}
