package com.backend.portfolio.Services;

import org.apache.tomcat.util.http.SameSiteCookies;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public ResponseCookie setTokenInCookie(String token) {
        return ResponseCookie.from("token", token)
                .httpOnly(true)
                .maxAge(24 * 60 * 60)
                .secure(false)
                .sameSite(SameSiteCookies.STRICT.toString())
                .path("/")
                .build();
    }

}
