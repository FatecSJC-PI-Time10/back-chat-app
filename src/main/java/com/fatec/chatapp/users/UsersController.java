package com.fatec.chatapp.users;

import com.fatec.chatapp.authentication.MyUserDetails;
import com.fatec.chatapp.utils.JWTUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

}
