package com.fatec.chatapp;

import com.fatec.chatapp.messages.MessageModel;
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
    @InjectMocks
    MessagesServiceImpl messagesService;

    final MessageModel stubMessage1 = new MessageModel("Era só mais um silva");

    @Test
    public void contextLoads() throws Exception {
        assertThat(messagesService).isNotNull();
    }

    @Test
    public void testToCreateMessage() {
        final MessageModel stub = messagesService.create(stubMessage1);

        assertEquals(stubMessage1.getId(), stub.getId());
        assertEquals(stubMessage1.getBody(), stub.getBody());
    }

    @Test
    public  void testToGetAllMessages() {
        final List<MessageModel> stub = messagesService.getAll();

        assertEquals(stubMessage1.getBody(), stub.get(0).getBody());
        assertEquals(1, stub.size());
    }

    @Test
    public void shouldFindOneById() {
        final List<MessageModel> messages = messagesService.getAll();
        final MessageModel message = messages.get(0);
        final MessageModel stub = messagesService.findOneById(message.getId());

        assertEquals(stubMessage1.getBody(), stub.getBody());
    }
}
