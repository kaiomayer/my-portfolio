package com.backend.portfolio.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.backend.portfolio.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenJWTService {
    @Value("${api.security.token.secret}")
    private String secret;

    @Value("${jwt.expiration.access}")
    private long jwtExpirationTime;

    public String generateToken(User user) {
        try {
            System.out.println("Secret: " + secret); //remover dps
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getUsername())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro na hora de gerar o token!", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT decoded = JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token);
            return decoded.getSubject();
        }
        catch (JWTVerificationException exception) {
            throw new RuntimeException("Erro na hora de validar o token!", exception);
        }
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + jwtExpirationTime);
    }
}
