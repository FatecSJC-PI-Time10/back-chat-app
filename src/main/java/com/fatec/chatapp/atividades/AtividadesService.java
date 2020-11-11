package com.fatec.chatapp.atividades;

import  java.util.List;
import java.util.UUID;

public interface AtividadesService {
    ActivityModel create(ActivityModel a);
    void delete(ActivityModel a);
    List<ActivityModel> getAll();
    ActivityModel findOneById(UUID id);
}