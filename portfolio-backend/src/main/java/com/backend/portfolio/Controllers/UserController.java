package com.backend.portfolio.Controllers;

import com.backend.portfolio.Exceptions.UserNotFoundException;
import com.backend.portfolio.Models.User;
import com.backend.portfolio.Services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        if (userService.findById(id).isEmpty()) {
            throw new UserNotFoundException("Usuário não existe");
        }
        User user = userService.findById(id).get();
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsernameById(@PathVariable String id) {
        if (userService.findById(id).isEmpty()) {
            throw new UserNotFoundException("Usuário não existe");
        }
        userService.delete(id);
        return ResponseEntity.ok("Usuário excluído com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> changeUser(@PathVariable String id, @RequestBody @Valid User novo) {
        if (userService.findById(id).isEmpty()) {
            throw new UserNotFoundException("Usuário não existe");
        }
        User user = userService.findById(id).get();
        user.setUsername(novo.getUsername());
        user.setBio(novo.getBio());

        if (novo.getPassword() != null && !novo.getPassword().isBlank()) {
            user.setPassword(novo.getPassword());
        }

        User updated = userService.update(user);
        return ResponseEntity.ok(updated);
    }
}
