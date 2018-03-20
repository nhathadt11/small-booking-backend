package com.nhatha.smallroombookingbackend.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.nhatha.smallroombookingbackend.config.security.AuthenticationContants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private AuthenticationManager authenticationManager;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
                                              HttpServletResponse response) throws AuthenticationException {
    try {
      Admin credentials = new ObjectMapper().readValue(request.getInputStream(), Admin.class);

      return authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              credentials.getEmail(),
              credentials.getPassword(),
              new ArrayList<>()
          )
      );
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request,
                                          HttpServletResponse response,
                                          FilterChain chain,
                                          Authentication authResult) throws IOException, ServletException {
    Date expireAt = new Date(System.currentTimeMillis() + AuthenticationContants.EXPIRATION_TIME);

    String token = Jwts.builder()
        .setSubject(((User) authResult.getPrincipal()).getUsername())
        .setExpiration(expireAt)
        .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
        .compact();

    response
        .getWriter()
        .write(
            new ObjectMapper()
                .writeValueAsString(new TokenModel(TOKEN_PREFIX + token, expireAt))
        );
  }
}
