package com.fatec.chatapp.participants;

import com.fatec.chatapp.chats.ChatsService;
import com.fatec.chatapp.users.UsersServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Participantes")
@RequestMapping(value = "/participants")
public class ParticipantsController {
    @Autowired
    ParticipantsServiceImpl participantsService;

    @GetMapping
    public List<ParticipantModel> getAllParticipants() {
        return participantsService.getAll();
    }

    @GetMapping("/{id}")
    public ParticipantModel findOneParticipantById(@PathVariable UUID id) {
        return participantsService.findOneById(id);
    }

    @PostMapping
    public ParticipantModel createParticipant(@RequestBody ParticipantDTO body) {
        return participantsService.create(body);
    }
}

