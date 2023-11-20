package com.RentRight.RentRight.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    @Value("${api.security.token.issuer}")
    private String issuer;
    @Value("${api.security.token.expiration_min}")
    private String expirationMin;

    public String generateToken(UserDetails user){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT
            .create()
            .withIssuer(issuer)
            .withSubject(user.getUsername())
            .withExpiresAt(getExpirationDate())
            .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error Generating Token");
        }
    }

           private Instant getExpirationDate(){
            return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
        }

    public String getUsername(String tokenJWT) {
        try{
            var algorithm = Algorithm.HMAC256(secret);
            return JWT 
            .require(algorithm)
            .withIssuer(issuer)
            .build()
            .verify(tokenJWT)
            .getSubject();
        } catch(JWTVerificationException exception) {
            throw new RuntimeException("Inspired or invalid token");
        }
    }
}
