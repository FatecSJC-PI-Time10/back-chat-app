package com.fatec.chatapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;


    @Override
    public UserModel create(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public UserModel findOneById() {
        return userRepository.getOne(0L);
    }
}
