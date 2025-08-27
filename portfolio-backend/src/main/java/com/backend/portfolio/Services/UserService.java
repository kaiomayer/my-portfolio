package com.backend.portfolio.Services;

import com.backend.portfolio.Dtos.LoginDTO;
import com.backend.portfolio.Models.User;
import com.backend.portfolio.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(LoginDTO data) {
        String encryptedPassword = encryptPassword(data.password());
        User user = new User(data.username(), encryptedPassword, "", "");

        return userRepository.save(user);
    }

    public String getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername();
        }
        return null;
    }

    public User update(User user) {
        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    private String encryptPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public void delete(String id) { userRepository.deleteById(id); }
    public Optional<User> findById(String id) { return userRepository.findById(id); }
    public UserDetails findByUsername(String username) { return userRepository.findByUsername(username); }
}
