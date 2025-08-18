package com.backend.portfolio.Controllers;

import com.backend.portfolio.Dtos.LoginDTO;
import com.backend.portfolio.Models.User;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(name = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginData, HttpServletResponse response) {
        String token = "";
        try {
            UsernamePasswordAuthenticationToken userData = new UsernamePasswordAuthenticationToken(loginData.getUsername(),
                    loginData.getPassword());
            Authentication auth = authenticationManager.authenticate(userData);

            token = tokenService.generateToken((User) auth.getPrincipal());

            ResponseCookie cookie = ResponseCookie.from("token", token)
                    .httpOnly(true)
                    .maxAge(24 * 60 * 60)
                    .secure(false)
                    .sameSite(SameSiteCookies.STRICT.toString())
                    .path("/")
                    .build();

            response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
            return ResponseEntity.ok(auth);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");

        }
    }

    @PostMapping(name = "logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> logout() {
        return ResponseEntity.noContent().build();
    }
}
