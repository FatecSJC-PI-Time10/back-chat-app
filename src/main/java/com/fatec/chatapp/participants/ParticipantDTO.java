package com.fatec.chatapp.participants;

import java.util.UUID;

public class ParticipantDTO {
    private UUID chatId;
    private UUID userId;

    public ParticipantDTO() {
    }

    public ParticipantDTO(UUID chatId, UUID userId) {
        this.chatId = chatId;
        this.userId = userId;
    }

    public UUID getChatId() {
        return chatId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
