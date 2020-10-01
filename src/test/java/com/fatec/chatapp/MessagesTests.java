package com.fatec.chatapp;

import com.fatec.chatapp.messages.MessageModule;
import com.fatec.chatapp.messages.MessagesController;
import com.fatec.chatapp.messages.MessagesServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;



@SpringBootTest
public class MessagesTests {
    @Autowired
    private MessagesController controller;

    @Autowired
    @InjectMocks
    MessagesServiceImpl messagesService;

    final MessageModule stubMessage1 = new MessageModule(null, "Só era mais um silva");

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testToCreateMessage() {
        final MessageModule stub = messagesService.createMessage(stubMessage1);

        assertEquals(stubMessage1.getId(), stub.getId());
        assertEquals(stubMessage1.getBody(), stub.getBody());
    }
}
