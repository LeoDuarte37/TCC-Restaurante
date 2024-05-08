package com.restaurante.grupo07.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.restaurante.grupo07.model.Login;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtService {

    private static final String SECRET_KEY = "3288b5a38e055df0ddf0fc36c2bab5b59b5ac2d4314c01874c260f193c7b79f2";

    public String generateToken(Login login) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(login.getUsername())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token!", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Erro ao validar o token!", exception);
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
