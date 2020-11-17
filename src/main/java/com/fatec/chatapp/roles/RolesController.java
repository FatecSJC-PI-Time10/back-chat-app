package com.fatec.chatapp.roles;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Roles")
@RequestMapping(value = "/roles")
public class RolesController {
  @Autowired
  RolesServiceImpl rolesService;

  @PostMapping
  public RoleModel create(@Valid @RequestBody RoleDTO body){
    final RoleModel model = new RoleModel(body.getName());

    return rolesService.create(model);
  }

  @GetMapping
  public List<RoleModel> getAll() {
    return rolesService.getAll();
  }
}
