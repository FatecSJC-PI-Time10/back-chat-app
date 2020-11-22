package com.fatec.chatapp.services;

import com.fatec.chatapp.models.UserDetailsModel;
import com.fatec.chatapp.models.UserModel;
import com.fatec.chatapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
  @Autowired
  UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserModel user = usersRepository.findOneByEmail(username);

    if (user == null) {
      throw  new UsernameNotFoundException("User name not found!");
    }

    return new UserDetailsModel(user);
  }
}
