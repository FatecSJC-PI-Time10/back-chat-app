package com.fatec.chatapp.users;

import com.fatec.chatapp.users.UserModule;

public interface UserService {
    public UserModule createUser(UserModule user);
    public UserModule getUserById();
}
