package com.fatec.chatapp.users;

import java.util.List;
import java.util.UUID;

public interface UsersService {
    UserModel create(UserModel u);
    UserModel findOneById(UUID id);
    List<UserModel> getAll();
    UserModel findOneByEmail(String e);
}
