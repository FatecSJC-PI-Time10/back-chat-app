package com.fatec.chatapp.controllers;

import com.fatec.chatapp.dtos.AddChatDTO;
import com.fatec.chatapp.dtos.AddRoleDTO;
import com.fatec.chatapp.models.ChatModel;
import com.fatec.chatapp.chats.ChatsServiceImpl;
import com.fatec.chatapp.models.RoleModel;
import com.fatec.chatapp.models.UserModel;
import com.fatec.chatapp.roles.RolesServiceImpl;
import com.fatec.chatapp.users.UsersServiceImpl;
import com.fatec.chatapp.utils.JWTUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Usuários")
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    ChatsServiceImpl chatsService;

    @Autowired
    RolesServiceImpl rolesService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private final JWTUtil jwtUtil = new JWTUtil("secret");

    @PostMapping
    public UserModel create(@Valid @RequestBody UserModel user){
        return usersService.create(user);
    }

    @GetMapping
    public List<UserModel> getAll() {
        return usersService.getAll();
    }

    @GetMapping(value = "/me")
    public ResponseEntity<UserModel> me(@RequestHeader("Authorization") String authorization) {
        final String jwt = authorization.substring(7);
        final String username = jwtUtil.extractUsername(jwt);
        final UserModel model = usersService.findOneByEmail(username);
        return ResponseEntity.ok(model);
    }

    @PostMapping(value = "/{id}/chats")
    public UserModel addChatToUser(@PathVariable("id") UUID userId, @RequestBody AddChatDTO body) {
        final UserModel user = usersService.findOneById(userId);
        final ChatModel chat = chatsService.findOneById(body.getChatId());

        return usersService.addChat(user, chat);
    }

    @PostMapping(value = "/{id}/roles")
    public UserModel addRoleToUser(@PathVariable("id") UUID userId, @RequestBody AddRoleDTO body) {
        final UserModel user = usersService.findOneById(userId);
        final RoleModel role = rolesService.findOneById(body.getRoleId());

        return usersService.addRole(user, role);
    }

    @GetMapping(value = "/{id}/contacts")
    public List<UserModel> getContacts(@PathVariable("id") UUID userId) {
        return usersService.getContacts(userId);
    }
}
