package com.fatec.chatapp.messages;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
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
    private String body;

    public MessageModel() { }

    public MessageModel(String body) {
        this.body = body;
    }

    public MessageModel(UUID id, String body) {
        this.id = id;
        this.body = body;
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

    @Override
    public String toString() {
        return "MessageModule{" +
                "id='" + id + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
