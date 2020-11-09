package com.fatec.chatapp.atividades;

import com.fatec.chatapp.users.UserModel;
import com.fatec.chatapp.users.UsersServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Atividades")
@RequestMapping(value = "/atividades")
public class AtividadesController {

    @Autowired
    AtividadesServiceImpl atividadesService;

    @Autowired
    UsersServiceImpl userService;

    //Listar Atividades
    @GetMapping
    public List<AtividadeModel> listarAtividades(){
        return atividadesService.getAll();
    }

    //Encontrar atividade por ID
    @GetMapping("/{id}")
    public AtividadeModel getAtividadeById(@PathVariable UUID id) {
        return atividadesService.findOneById(id);
    }

    //Salvar atividade
    @PostMapping
    public AtividadeModel salvaAtividadeModel(@RequestBody AtividadeDTO atividade) {
        UserModel usuario = userService.findOneById(atividade.getUserId());
        UserModel resquesteUser = userService.findOneById(atividade.getRequestId());
        AtividadeModel model = new AtividadeModel(atividade.getTitulo(), atividade.getDescricao(), usuario, resquesteUser, true);
        return atividadesService.create(model);
    }

    //Deletar atividade
    @DeleteMapping
    public void deleteAtividade (@RequestBody AtividadeModel atividade) {
        atividadesService.delete(atividade);
    }

    //Atualizar atividade
    @PutMapping
    public AtividadeModel atualizarAtividadeModel(@RequestBody AtividadeModel atividade) {
        return atividadesService.create(atividade);
    }
}