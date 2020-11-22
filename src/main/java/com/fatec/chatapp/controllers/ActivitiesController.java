package com.fatec.chatapp.controllers;

import com.fatec.chatapp.services.ActivitiesServiceImpl;
import com.fatec.chatapp.dtos.ActivityDTO;
import com.fatec.chatapp.models.ActivityModel;
import com.fatec.chatapp.models.UserModel;
import com.fatec.chatapp.services.UsersServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Activities")
@RequestMapping(value = "/activities")
public class ActivitiesController {

    @Autowired
    ActivitiesServiceImpl atividadesService;

    @Autowired
    UsersServiceImpl userService;

    //Listar Atividades
    @GetMapping
    public List<ActivityModel> listarAtividades(){
        return atividadesService.getAll();
    }

    //Encontrar atividade por ID
    @GetMapping("/{id}")
    public ActivityModel getAtividadeById(@PathVariable UUID id) {
        return atividadesService.findOneById(id);
    }

    //Salvar atividade
    @PostMapping
    public ActivityModel salvaAtividadeModel(@Valid @RequestBody ActivityDTO activity) {
        UserModel usuario = userService.findOneById(activity.getUserId());
        ActivityModel model = new ActivityModel(activity.getTitle(), activity.getDescription(), usuario, activity.getIsActive());
        return atividadesService.create(model);
    }

    //Deletar atividade
    @DeleteMapping
    public void deleteAtividade (@RequestBody ActivityModel atividade) {
        atividadesService.delete(atividade);
    }

    //Atualizar atividade
    @PutMapping("{id}")
    public ActivityModel updateActivity(@PathVariable UUID id, @RequestBody ActivityDTO body) {
        return atividadesService.updateActivityById(id, body);
    }
}