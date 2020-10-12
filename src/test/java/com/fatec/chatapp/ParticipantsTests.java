package com.fatec.chatapp;

import com.fatec.chatapp.participants.ParticipantsServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ParticipantsTests {
    @Autowired
    @InjectMocks
    ParticipantsServiceImpl participantsService;

    @Test
    void contextLoads() throws Exception {
        assertThat(participantsService).isNotNull();
    }

    @Test
    public void shouldCreateOne() {

    }

    @Test
    public void shouldFindOneById() {

    }


}
