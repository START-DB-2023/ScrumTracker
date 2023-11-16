package com.db.scrumtrackerapi.security.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {
    
    private String secret = ";1hdNdT}sDAB-Vai1n(QZj,'TeHlyETelXMa)GP)rIeB~]+(#h";
    private String issuer = "Scrum Tracker";

    public String generateToken(UserDetails userDetails) {
        return JWT.create().withIssuer(issuer)
        .withSubject(userDetails.getUsername())
        .withExpiresAt(LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00")))
        .sign(Algorithm.HMAC256(secret));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer(issuer)
                .build()
                .verify(token).getSubject();
    }
}
