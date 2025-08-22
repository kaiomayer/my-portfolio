package com.backend.portfolio.Controllers;

import com.backend.portfolio.Dtos.LoginDTO;
import com.backend.portfolio.Exceptions.UserAlreadyExistsException;
import com.backend.portfolio.Exceptions.UserNotFoundException;
import com.backend.portfolio.Models.User;
import com.backend.portfolio.Services.AuthService;
import com.backend.portfolio.Services.TokenJWTService;
import com.backend.portfolio.Services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;

    private final TokenJWTService tokenJWTService;

    private final UserService userService;

    private final AuthService authService;

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO data, HttpServletResponse response) {
        try {
            if (authService.loadUserByUsername(data.username()) == null) {
                throw new UserNotFoundException("Usuário não encontrado.");
            }

            var userData = new UsernamePasswordAuthenticationToken(data.username(), data.password());
            var auth = authenticationManager.authenticate(userData);

            String token = tokenJWTService.generateToken((User) auth.getPrincipal());

            ResponseCookie cookie = authService.setTokenInCookie(token);
            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

            return ResponseEntity.noContent().build();

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos"); //mudar dps

        }
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> register(@Valid @RequestBody LoginDTO data) { //usando o dto do login por enquanto;
        if (authService.loadUserByUsername(data.username()) != null) {
            throw new UserAlreadyExistsException("Usuário já existe!"); 
        }

        User user = userService.save(data);
        return ResponseEntity.ok(user); //alterar dps
    }

    @PostMapping(path = "/logout")
    public ResponseEntity<HttpStatus> logout() {
        return ResponseEntity.noContent().build();
    }
}
