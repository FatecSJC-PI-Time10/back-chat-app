package com.fatec.chatapp.chats;

import com.fatec.chatapp.messages.MessageModel;
import com.fatec.chatapp.participants.ParticipantModel;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "chat")
public class ChatModel {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "chat_id", updatable = false, nullable = false)
  @ColumnDefault("random_uuid()")
  @Type(type = "uuid-char")
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "is_active")
  private Boolean isActive;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "chat", fetch = FetchType.LAZY)
  private Set<ParticipantModel> participants;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "chat", fetch = FetchType.LAZY)
  private Set<MessageModel> messages;

  public ChatModel() {
  }

  public ChatModel(String name, Boolean isActive) {
    this.name = name;
    this.isActive = isActive;
  }

  public ChatModel(UUID id, String name, Boolean isActive) {
    this.id = id;
    this.name = name;
    this.isActive = isActive;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<ParticipantModel> getParticipants() {
    return participants;
  }

  public void setParticipants(Set<ParticipantModel> participants) {
    this.participants = participants;
  }

  public Set<MessageModel> getMessages() {
    return messages;
  }

  public void setMessages(Set<MessageModel> messages) {
    this.messages = messages;
  }

  @Override
  public String toString() {
    return "ChatModel{" +
            "id='" + id + '\'' +
            ", nome='" + name + '\'' +
            ", isActive=" + isActive +
            '}';
  }
}
