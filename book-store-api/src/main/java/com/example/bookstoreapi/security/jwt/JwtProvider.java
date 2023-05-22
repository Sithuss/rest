package com.example.bookstoreapi.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    @Value("${app.jwt.secret}")
    private String jwtSecret;
    @Value("${app.jwt.token.prefix}")
    private String jwtTokenPrefix;
    @Value("${app.jwt.header.string}")
    private String jwtHeaderString;
    @Value("${app.jwt.expiration-in-ms}")
    private String jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        String authorities = authentication.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining());

        return Jwts.builder().setSubject(authentication.getName())
                .claim("roles",authorities)
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS512,jwtSecret).compact();
    }
}
