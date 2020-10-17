package com.fatec.chatapp.users;

import java.util.List;
import java.util.UUID;

public interface UsersService {
    public UserModel create(UserModel u);
    public UserModel findOneById(UUID id);
    public List<UserModel> getAll();
}
