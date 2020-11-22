package com.fatec.chatapp.services;

import com.fatec.chatapp.models.RoleModel;

import java.util.List;
import java.util.UUID;

public interface RolesService {
  RoleModel create(RoleModel r);
  RoleModel findOneById(UUID id);
  List<RoleModel> getAll();
  void deleteRole(RoleModel r);
}
