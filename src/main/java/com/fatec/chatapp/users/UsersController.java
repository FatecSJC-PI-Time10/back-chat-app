package com.fatec.chatapp.users;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Usuários")
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    UsersServiceImpl userService;

    @PostMapping
    public UserModel create(@RequestBody UserModel user){
        return userService.create(user);
    }

    @GetMapping
    public List<UserModel> getAll() {
        return userService.getAll();
    }
}
