package com.fatec.chatapp.users;

public interface UserService {
    public UserModel create(UserModel user);
    public UserModel findOneById();
}
