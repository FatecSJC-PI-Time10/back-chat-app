package com.fatec.chatapp.atividades;

import  java.util.List;
import java.util.UUID;

public interface AtividadesService {
    AtividadeModel create(AtividadeModel a);
    void delete(AtividadeModel a);
    List<AtividadeModel> getAll();
    AtividadeModel findOneById(UUID id);
}