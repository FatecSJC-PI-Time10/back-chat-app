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

    @Autowired
    private ChatsController controller;

    private ChatModel stubChatModel = new ChatModel(null, "String",true);

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
        assertThat(chatService).isNotNull();
    }

    @Test
    public void testCreateChat() throws  Exception{
        ChatModel stub1 = chatService.create(stubChatModel);
        assertEquals(stub1.getId(), stubChatModel.getId());
        assertEquals(stub1.getActive(), stubChatModel.getActive());
    }

    @Test
    public void testShouldGetAllChats() throws Exception{
        List<ChatModel> stub = chatService.getAll();

        assertEquals(stubChatModel.getActive(), stub.get(0).getActive());
        assertEquals(1, stub.size());
    }
}
