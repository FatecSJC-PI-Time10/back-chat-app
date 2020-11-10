package com.fatec.chatapp.atividades;

import java.util.UUID;

public class AtividadeDTO {
    private UUID userId;
    private String titulo;
    private String descricao;

    public AtividadeDTO() {
    }

    public AtividadeDTO(UUID userId, String titulo, String descricao) {
        this.userId = userId;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
