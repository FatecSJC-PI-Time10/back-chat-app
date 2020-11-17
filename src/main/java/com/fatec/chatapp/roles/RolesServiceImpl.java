package com.fatec.chatapp.roles;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class RolesServiceImpl implements RolesService {
  @Autowired
  RolesRepository rolesRepository;

  @Override
  public RoleModel create(RoleModel r) {
    return rolesRepository.save(r);
  }

  @Override
  public RoleModel findOneById(UUID id) {
    return rolesRepository.findOneById(id);
  }

  @Override
  public List<RoleModel> getAll() {
    return rolesRepository.findAll();
  }
}
