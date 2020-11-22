package com.fatec.chatapp.services;

import com.fatec.chatapp.models.RoleModel;
import com.fatec.chatapp.repositories.RolesRepository;
import com.fatec.chatapp.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
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

  @Override
  public void deleteRole(RoleModel r) {
    rolesRepository.delete(r);
  }
}
