package com.fatec.chatapp;

import com.fatec.chatapp.chats.ChatController;
import com.fatec.chatapp.chats.ChatModule;
import com.fatec.chatapp.chats.ChatServiceImpl;
import com.fatec.chatapp.messages.MessagesServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@SpringBootTest
public class ChatsTests {
    @Autowired
    @InjectMocks
    ChatServiceImpl chatService;

    @Autowired
    private ChatController controller;

    private ChatModule stubChatModule = new ChatModule(null, "String",true);




    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testCreateChat() throws  Exception{
        ChatModule stub1 = chatService.createChat(stubChatModule);
        assertEquals(stub1.getId(), stubChatModule.getId());
        assertEquals(stub1.getActive(), stubChatModule.getActive());
    }

    @Test
    public void testGetChatById() throws Exception{
        ChatModule stub1 = chatService.getChatById();
        assertEquals(stub1.getNome(), stubChatModule.getNome());
        assertEquals(stub1.getActive(), stubChatModule.getActive());
    }
}
