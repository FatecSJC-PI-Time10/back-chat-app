package com.fatec.chatapp.utils;

import com.fatec.chatapp.userdetails.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTRequestFilter extends OncePerRequestFilter {
  @Autowired
  private MyUserDetailsService userDetailsService;

  private JWTUtil jwtUtil = new JWTUtil("secret");

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

  }
}
