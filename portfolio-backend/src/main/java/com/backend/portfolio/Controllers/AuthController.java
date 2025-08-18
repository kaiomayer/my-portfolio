package com.backend.portfolio.Controllers;

import com.backend.portfolio.Dtos.LoginDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private TokenService tokenService;

    @PostMapping(name = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginData) {
        String token = "";
        try {
            UsernamePasswordAuthenticationToken userData = new UsernamePasswordAuthenticationToken()
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");

        }
        return ResponseEntity.ok().body(token);
    }

    @PostMapping(name = "logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> logout() {
        return ResponseEntity.noContent().build();
    }
}
