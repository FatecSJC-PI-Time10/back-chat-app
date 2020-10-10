package com.fatec.chatapp.participants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("participants")
public class ParticipantsServiceImpl implements ParticipantsService {
    @Autowired
    ParticipantsRepository participantsRepository;

    @Override
    public ParticipantModel create(ParticipantModel p) {
        return participantsRepository.save(p);
    }

    @Override
    public ParticipantModel findOneById(UUID id) {
        return participantsRepository.findOneById(id);
    }

    @Override
    public List<ParticipantModel> getAll() {
        return participantsRepository.findAll();
    }
}
