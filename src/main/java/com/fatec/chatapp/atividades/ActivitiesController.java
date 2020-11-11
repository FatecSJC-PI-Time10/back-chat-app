package com.fatec.chatapp.atividades;

import com.fatec.chatapp.users.UserModel;
import com.fatec.chatapp.users.UsersServiceImpl;
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
    AtividadesServiceImpl atividadesService;

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
    @PutMapping
    public ActivityModel atualizarAtividadeModel(@RequestBody ActivityModel atividade) {
        return atividadesService.create(atividade);
    }
}