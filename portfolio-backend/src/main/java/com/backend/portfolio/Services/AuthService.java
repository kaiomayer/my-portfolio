package com.backend.portfolio.Services;

import com.backend.portfolio.Repositories.UserRepository;
import org.apache.tomcat.util.http.SameSiteCookies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public ResponseCookie setTokenInCookie(String token) {
        return ResponseCookie.from("token", token)
                .httpOnly(true)
                .maxAge(24 * 60 * 60)
                .secure(false)
                .sameSite("Strict")
                .path("/")
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
