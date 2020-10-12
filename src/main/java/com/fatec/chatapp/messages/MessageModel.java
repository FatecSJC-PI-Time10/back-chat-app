package com.fatec.chatapp.messages;

import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.users.UserModel;
import org.hibernate.annotations.ColumnDefault;
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
    @ColumnDefault("random_uuid()")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "body")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
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

