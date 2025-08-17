package com.backend.portfolio.Controllers;

import com.backend.portfolio.Dtos.LoginDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping(name = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginData) {
        String token = "";
        return ResponseEntity.ok().body(token);
    }

    @PostMapping(name = "logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> logout(){
        return ResponseEntity.noContent().build();
    }
}
