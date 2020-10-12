package com.fatec.chatapp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    UsersServiceImpl userService;

    @PostMapping("/users")
    public UserModel create(@RequestBody UserModel user){
        return userService.create(user);
    }

    @GetMapping("/users")
    public List<UserModel> getAll() {
        return userService.getAll();
    }
}
