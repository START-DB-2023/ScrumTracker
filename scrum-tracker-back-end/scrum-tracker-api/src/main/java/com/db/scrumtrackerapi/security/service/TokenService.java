package com.db.scrumtrackerapi.security.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * Service class for handling JWT tokens.
 */
@Service
public class TokenService {

    private final String secret = ";1hdNdT}sDAB-Vai1n(QZj,'TeHlyETelXMa)GP)rIeB~]+(#h";
    private final String issuer = "Scrum Tracker";

    /**
     * Generates a JWT token based on user details.
     *
     * @param userDetails The user details.
     * @return The generated JWT token.
     */
    public String generateToken(UserDetails userDetails) {
        return JWT.create()
                .withIssuer(issuer)
                .withSubject(userDetails.getUsername())
                .withExpiresAt(LocalDateTime.now().plusHours(1L).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * Retrieves the subject (username) from a JWT token.
     *
     * @param token The JWT token.
     * @return The subject (username) extracted from the token.
     */
    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer(issuer)
                .build()
                .verify(token)
                .getSubject();
    }
}
