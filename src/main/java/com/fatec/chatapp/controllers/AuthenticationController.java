package com.fatec.chatapp.controllers;

import com.fatec.chatapp.authentication.AuthenticationRequest;
import com.fatec.chatapp.authentication.AuthenticationResponse;
import com.fatec.chatapp.authentication.MyUserDetailsService;
import com.fatec.chatapp.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private MyUserDetailsService userDetailsService;

  private JWTUtil jwtUtil = new JWTUtil("secret");

  @PostMapping
  public ResponseEntity<?> createAuthentication(@Valid @RequestBody AuthenticationRequest body) throws Exception {
    try {
      final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());
      authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    } catch (BadCredentialsException exception) {
      throw new Exception("Incorrect username or password", exception);
    }

    final UserDetails userDetails = userDetailsService.loadUserByUsername(body.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }
}
