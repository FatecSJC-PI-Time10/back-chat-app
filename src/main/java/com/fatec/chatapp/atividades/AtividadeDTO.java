package com.fatec.chatapp.atividades;

import java.util.UUID;

public class AtividadeDTO {
    private UUID userId;
    private UUID requestId;
    private String titulo;
    private String descricao;

    public AtividadeDTO() {
    }

    public AtividadeDTO(UUID userId, UUID requestId, String titulo, String descricao) {
        this.userId = userId;
        this.requestId = requestId;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
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
