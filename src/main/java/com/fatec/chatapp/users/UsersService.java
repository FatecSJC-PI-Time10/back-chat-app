package com.fatec.chatapp.users;

import com.fatec.chatapp.chats.ChatModel;
import com.fatec.chatapp.roles.RoleModel;

import java.util.List;
import java.util.UUID;

public interface UsersService {
    UserModel create(UserModel u);
    UserModel findOneById(UUID id);
    List<UserModel> getAll();
    UserModel findOneByEmail(String e);
    UserModel updateById(UUID id, UserModel u);
    UserModel addChat(UserModel u, ChatModel c);
    UserModel addRole(UserModel u, RoleModel r);
}
