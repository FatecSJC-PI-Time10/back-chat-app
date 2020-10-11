package com.fatec.chatapp.participants;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParticipantsRepository extends JpaRepository<ParticipantModel, Long> {
    ParticipantModel findOneById(UUID uuid);
}
