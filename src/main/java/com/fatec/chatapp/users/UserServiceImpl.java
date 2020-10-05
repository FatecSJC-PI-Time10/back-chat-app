package com.fatec.chatapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;


    @Override
    public UserModule createUser(UserModule user) {
        return userRepository.save(user);
    }

    @Override
    public UserModule getUserById() {
        return userRepository.getOne(0L);
    }
}
