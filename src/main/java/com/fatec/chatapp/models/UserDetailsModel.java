package com.fatec.chatapp.models;

import com.fatec.chatapp.models.RoleModel;
import com.fatec.chatapp.models.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UserDetailsModel implements UserDetails {
  private final UserModel user;

  public UserDetailsModel(UserModel user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<RoleModel> roleModels = user.getRoles();
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    for (RoleModel roleModel : roleModels) {
      authorities.add(new SimpleGrantedAuthority(roleModel.getName()));
    }

    return authorities;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
