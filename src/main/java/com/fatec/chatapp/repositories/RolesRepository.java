package com.fatec.chatapp.roles;

import com.fatec.chatapp.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<RoleModel, Long> {
  RoleModel findOneById(UUID id);
}
