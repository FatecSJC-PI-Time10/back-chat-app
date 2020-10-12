package com.fatec.chatapp;

import com.fatec.chatapp.messages.MessagesServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

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
