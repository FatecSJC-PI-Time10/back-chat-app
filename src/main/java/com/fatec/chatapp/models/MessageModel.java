package com.fatec.chatapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "message")
public class MessageModel {
    @Id 
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "message_id", updatable = false, nullable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "body")
    private String body;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserModel user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="chat_id")
    private ChatModel chat;

    public MessageModel() { }

    public MessageModel(String body) {
        this.body = body;
    }

    public MessageModel(UUID id, String body) {
        this.id = id;
        this.body = body;
    }


    public MessageModel(String body, UserModel user, ChatModel chat) {
        this.body = body;
        this.user = user;
        this.chat = chat;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public ChatModel getChat() {
        return chat;
    }

    public void setChat(ChatModel chat) {
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "MessageModule{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

