package com.fatec.chatapp.dtos;

public class ChatDTO {
  private String name;
  private Boolean isActive;

  public ChatDTO() {
  }

  public ChatDTO(String name, Boolean isActive) {
    this.name = name;
    this.isActive = isActive;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getISActive() {
    return isActive;
  }

  public void setIsActive(Boolean active) {
    isActive = active;
  }
}
