package com.backend.portfolio.Controllers;

import com.backend.portfolio.Dtos.LoginDTO;
import com.backend.portfolio.Models.User;
import com.backend.portfolio.Repositories.UserRepository;
import com.backend.portfolio.Services.AuthService;
import com.backend.portfolio.Services.TokenJWTService;
import com.backend.portfolio.Services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.tomcat.util.http.SameSiteCookies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private TokenJWTService tokenJWTService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginData, HttpServletResponse response) {
        try {
            var userData = new UsernamePasswordAuthenticationToken(loginData.getUsername(),
                    loginData.getPassword());

            Authentication auth = authenticationManager.authenticate(userData);
            String token = tokenJWTService.generateToken((User) auth.getPrincipal());
            ResponseCookie cookie = authService.setTokenInCookie(token);

            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
            return ResponseEntity.ok(auth);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");

        }
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@Valid @RequestBody LoginDTO data) { //usando o dto do login por enquanto;
        if (userRepository.findByUsername(data.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome de usuário já existe!");
        }

        User user = userService.save(data);
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> logout() {
        return ResponseEntity.noContent().build();
    }
}
