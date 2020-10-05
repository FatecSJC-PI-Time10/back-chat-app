package com.fatec.chatapp.chats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private Boolean isActive;

    public ChatModel() { }

    public ChatModel(String id, String nome, Boolean isActive) {
        this.id = id;
        this.nome = nome;
        this.isActive = isActive;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ChatModel{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
