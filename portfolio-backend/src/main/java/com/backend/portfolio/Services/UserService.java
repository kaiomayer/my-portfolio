package com.backend.portfolio.Services;

import com.backend.portfolio.Dtos.LoginDTO;
import com.backend.portfolio.Models.User;
import com.backend.portfolio.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(LoginDTO data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        User user = new User(data.getUsername(), encryptedPassword);

        userRepository.save(user);
        return user;
    }

    public void delete(String id) { userRepository.deleteById(id); }
    public Optional<User> findById(String id) { return userRepository.findById(id); }
}
