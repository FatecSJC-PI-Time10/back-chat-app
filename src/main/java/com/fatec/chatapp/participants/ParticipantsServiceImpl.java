package com.fatec.chatapp.participants;

import com.fatec.chatapp.chats.ChatsRepository;
import com.fatec.chatapp.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("participants")
public class ParticipantsServiceImpl implements ParticipantsService {
    @Autowired
    ParticipantsRepository participantsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ChatsRepository chatsRepository;

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
