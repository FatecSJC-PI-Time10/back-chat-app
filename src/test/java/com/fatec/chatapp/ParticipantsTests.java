package com.fatec.chatapp;

import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.participants.ParticipantModel;
import com.fatec.chatapp.participants.ParticipantsRepository;
import com.fatec.chatapp.participants.ParticipantsServiceImpl;
import com.fatec.chatapp.users.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class ParticipantServiceTests {
  @MockBean
  private ParticipantsRepository participantsRepository;

  @Autowired
  ParticipantsServiceImpl participantsService;

  final ChatModel chatOne = new ChatModel(UUID.randomUUID(), "ChatOne", true);
  final UserModel userOne = new UserModel(UUID.randomUUID(), "UserOne", "123123", "adawd@adwda.com", "1234567");
  final ParticipantModel participantOne = new ParticipantModel(chatOne, userOne);

  @Test
  void contextLoads() throws Exception {
    assertNotNull(participantsService);
    assertNotNull(participantsRepository);
  }

  @Test
  public void shouldCreateOne() {
    given(participantsRepository.save(participantOne)).willReturn(participantOne);
    ParticipantModel stub = participantsService.create(participantOne);

    assertEquals(participantOne.getId(), stub.getId());
    assertEquals(participantOne.getUser(), stub.getUser());
    assertEquals(participantOne.getChat(), stub.getChat());
  }

  @Test
  public void shouldFindOneById() {
    given(participantsRepository.findOneById(participantOne.getId())).willReturn(participantOne);
    ParticipantModel stub = participantsService.findOneById(participantOne.getId());

    assertEquals(participantOne.getId(), stub.getId());
    assertEquals(participantOne.getUser().getCpf(), stub.getUser().getCpf());
    assertEquals(participantOne.getChat().getIsActive(), stub.getChat().getIsActive());
  }
}

@WebMvcTest
class ParticipantsControllerTests {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  ParticipantsServiceImpl participantsService;

  @Test
  void contextLoads() throws Exception {
    assertNotNull(mockMvc);
    assertNotNull(participantsService);
  }
}