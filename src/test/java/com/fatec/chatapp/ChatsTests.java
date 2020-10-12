package com.fatec.chatapp;

import com.fatec.chatapp.chats.ChatsController;
import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.chats.ChatsServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@SpringBootTest
public class ChatsTests {
    @Autowired
    @InjectMocks
    ChatsServiceImpl chatService;

    private ChatModel stubChatModel = new ChatModel(null, "String",true);

    @Test
    public void contextLoads() throws Exception {
        assertThat(chatService).isNotNull();
    }

    @Test
    public void shouldCreateChat() throws  Exception{
        ChatModel stub1 = chatService.create(stubChatModel);
        assertEquals(stub1.getId(), stubChatModel.getId());
        assertEquals(stub1.getIsActive(), stubChatModel.getIsActive());
    }

    @Test
    public void shouldGetAllChats() throws Exception{
        List<ChatModel> stub = chatService.getAll();

        assertEquals(stubChatModel.getIsActive(), stub.get(0).getIsActive());
        assertEquals(1, stub.size());
    }
}
