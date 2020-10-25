package com.fatec.chatapp.authentication;

import com.fatec.chatapp.users.UserModel;
import com.fatec.chatapp.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

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

    return new MyUserDetails(user);
  }
}
