package com.fatec.chatapp;

import com.fatec.chatapp.messages.MessageModule;
import com.fatec.chatapp.messages.MessagesController;
import com.fatec.chatapp.messages.MessagesServiceImpl;
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
    private MessagesController controller;

    @Autowired
    @InjectMocks
    MessagesServiceImpl messagesService;

    final MessageModule stubMessage1 = new MessageModule(null, "Era só mais um silva");

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

    @Test
    public  void testToGetAllMessages() {
        final List<MessageModule> stub = messagesService.getAllMessages();

        assertEquals(stubMessage1.getBody(), stub.get(0).getBody());
        assertEquals(1, stub.size());
    }
}
