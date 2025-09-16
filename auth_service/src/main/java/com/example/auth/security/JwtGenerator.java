package com.example.auth.security;

import io.micronaut.security.token.jwt.generator.JwtTokenGenerator;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
//import io.micronaut.security.authentication.UserDetails;

@Singleton
@RequiredArgsConstructor
public class JwtGenerator {

    private final JwtTokenGenerator tokenGenerator;

//    public String generateToken(UserDe)
    public String generateToken(String username, String role){
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub",username);
        claims.put("role",role);

        return tokenGenerator.generateToken(claims).orElseThrow(
                ()->new RuntimeException("Failed to generate token")
        );
    }
}
