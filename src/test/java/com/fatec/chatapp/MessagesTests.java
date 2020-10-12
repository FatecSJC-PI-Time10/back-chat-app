package com.fatec.chatapp;

import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.chats.ChatsServiceImpl;
import com.fatec.chatapp.messages.MessageDTO;
import com.fatec.chatapp.messages.MessageModel;
import com.fatec.chatapp.messages.MessagesServiceImpl;
import com.fatec.chatapp.users.UserModel;
import com.fatec.chatapp.users.UsersServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@SpringBootTest
public class MessagesTests {
    @Autowired
    @InjectMocks
    MessagesServiceImpl messagesService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(messagesService).isNotNull();
    }

    @Test
    public void shouldCreateMessage() {

    }

    @Test
    public  void shouldGetAllMessages() {

    }

    @Test
    public void shouldFindOneById() {

    }
}
