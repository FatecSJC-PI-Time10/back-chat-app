package com.fatec.chatapp.roles;

import java.util.List;
import java.util.UUID;

public interface RolesService {
  RoleModel create(RoleModel r);
  RoleModel findOneById(UUID id);
  List<RoleModel> getAll();
}
