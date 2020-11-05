package com.fatec.chatapp.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatec.chatapp.atividades.AtividadeModel;

import com.fatec.chatapp.messages.MessageModel;
import com.fatec.chatapp.participants.ParticipantModel;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id", updatable = false, nullable = false)
    @ColumnDefault("gen_random_uuid()")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<ParticipantModel> participants = new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<MessageModel> messages = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<AtividadeModel> atividades;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<AtividadeModel> atividadeRequisitadas;

    public UserModel() {
    }

    public UserModel(String name, String cpf, String email, String password, HashSet<Role> roles) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UserModel(UUID id, String name, String cpf, String email, String password) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
