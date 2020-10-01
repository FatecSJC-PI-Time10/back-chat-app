package com.fatec.chatapp.messages;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MessageModule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String body;

    public MessageModule() { }

    public MessageModule(String id, String body) {
        this.id = id;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
