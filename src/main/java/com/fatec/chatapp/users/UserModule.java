package com.fatec.chatapp.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private String cpf;
    private String email;
    private String password;
    private String address;
    private String cityAddress;
    private String stateAddress;
    private String cepAddress;
    private Boolean isActive;

    public UserModule() {
    }

    public UserModule(String id, String nome, String cpf, String email, String password, String address, String cityAddress, String stateAddress, String cepAddress, Boolean isActive) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.address = address;
        this.cityAddress = cityAddress;
        this.stateAddress = stateAddress;
        this.cepAddress = cepAddress;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public String getStateAddress() {
        return stateAddress;
    }

    public void setStateAddress(String stateAddress) {
        this.stateAddress = stateAddress;
    }

    public String getCepAddress() {
        return cepAddress;
    }

    public void setCepAddress(String cepAddress) {
        this.cepAddress = cepAddress;
    }
}
