package com.fatec.chatapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/user")
    public UserModule createUser(@RequestBody UserModule user){
        return userService.createUser(user);
    }



}
