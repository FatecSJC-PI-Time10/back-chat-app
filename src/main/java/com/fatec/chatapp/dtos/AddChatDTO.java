package com.fatec.chatapp.dtos;

import java.util.UUID;

public class AddChatDTO {
  private UUID chatId;

  public AddChatDTO() {
  }

  public UUID getChatId() {
    return chatId;
  }

  public void setChatId(UUID chatId) {
    this.chatId = chatId;
  }
}
