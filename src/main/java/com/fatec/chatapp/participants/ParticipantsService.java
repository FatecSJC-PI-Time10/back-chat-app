package com.fatec.chatapp.participants;

import java.util.List;
import java.util.UUID;

public interface ParticipantsService {
    ParticipantModel create(ParticipantModel p);
    ParticipantModel findOneById(UUID id);
    List<ParticipantModel> getAll();
}
