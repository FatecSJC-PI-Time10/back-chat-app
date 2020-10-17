package com.fatec.chatapp.messages;

import java.util.UUID;

public class MessageDTO {
    private String body;
    private UUID userId;
    private UUID chatId;

    public MessageDTO() {
    }

    public MessageDTO(String body, UUID userId, UUID chatId) {
        this.body = body;
        this.userId = userId;
        this.chatId = chatId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
