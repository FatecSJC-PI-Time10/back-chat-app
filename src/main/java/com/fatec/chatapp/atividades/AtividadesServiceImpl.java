package com.fatec.chatapp.atividades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("AtividadesService")
public class AtividadesServiceImpl implements AtividadesService {
    @Autowired
    AtividadesRepository atividadesRepository;


    @Override
    public AtividadeModel create(AtividadeModel a) {
        return atividadesRepository.save(a);
    }

    @Override
    public void delete (AtividadeModel a) {
        atividadesRepository.delete(a);
    }

    @Override
    public List<AtividadeModel> getAll() {
        return atividadesRepository.findAll();
    }

    @Override
    public AtividadeModel findOneById(UUID id) {
        return atividadesRepository.findById(id);
    }
}