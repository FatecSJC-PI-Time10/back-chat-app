package com.fatec.chatapp.dtos;

import java.util.UUID;

public class AddRoleDTO {
  private UUID roleId;

  public AddRoleDTO() {
  }

  public AddRoleDTO(UUID roleId) {
    this.roleId = roleId;
  }

  public UUID getRoleId() {
    return roleId;
  }

  public void setRoleId(UUID roleId) {
    this.roleId = roleId;
  }
}
