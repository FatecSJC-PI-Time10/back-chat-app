package com.fatec.chatapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserModel create(UserModel user) {
        return usersRepository.save(user);
    }

    @Override
    public UserModel findOneById(UUID id) {
        return usersRepository.findOneById(id);
    }

    @Override
    public List<UserModel> getAll() {
        return usersRepository.findAll();
    }
}
