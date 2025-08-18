package com.backend.portfolio.Services;

import com.backend.portfolio.Dtos.LoginDTO;
import com.backend.portfolio.Models.User;
import com.backend.portfolio.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(LoginDTO data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        User user = new User(data.getUsername(), encryptedPassword);

        userRepository.save(user);
        return user;
    }
}
