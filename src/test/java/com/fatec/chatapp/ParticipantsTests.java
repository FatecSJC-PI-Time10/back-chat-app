package com.fatec.chatapp;

import com.fatec.chatapp.participants.ParticipantModel;
import com.fatec.chatapp.participants.ParticipantsServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@SpringBootTest
class ParticipantsTests {
	@Autowired
	@InjectMocks
	ParticipantsServiceImpl participantsService;

	final ParticipantModel participantStub = new ParticipantModel();

	@Test
	void contextLoads() throws Exception {
		assertThat(participantsService).isNotNull();
	}

	@Test
	public void shouldCreateOne() {
		final ParticipantModel stub = participantsService.create(participantStub);

		assertEquals(participantStub.getId(), stub.getId());
	}

	@Test
	public void shouldFindOneById() {
		final List<ParticipantModel> participants = participantsService.getAll();
		final ParticipantModel participant = participants.get(0);
		final ParticipantModel stub = participantsService.findOneById(participant.getId());

		assertEquals(participant.getId(), stub.getId());
	}


}
