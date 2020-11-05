package com.fatec.chatapp.atividades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AtividadesRepository extends JpaRepository<AtividadeModel, Long> {
    AtividadeModel findById(UUID id);
}