package com.fatec.chatapp.participants;

import com.fatec.chatapp.chats.ChatsService;
import com.fatec.chatapp.users.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ParticipantsController {
    @Autowired
    ParticipantsServiceImpl participantsService;

    @GetMapping("/participants")
    public List<ParticipantModel> getAllParticipants() {
        return participantsService.getAll();
    }

    @GetMapping("/participants/{id}")
    public ParticipantModel findOneParticipantById(@PathVariable UUID id) {
        return participantsService.findOneById(id);
    }

    @PostMapping("/participants")
    public ParticipantModel createParticipant(@RequestBody ParticipantDTO body) {
        return participantsService.create(body);
    }
}

