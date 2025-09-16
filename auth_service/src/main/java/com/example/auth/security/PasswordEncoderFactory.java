package com.example.auth.security;

import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;
import org.mindrot.jbcrypt.BCrypt;

@Factory
public class PasswordEncoderFactory {

    @Singleton
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoder();
    }

    public static class PasswordEncoder{
        public String encode(String rawPassword){
            return BCrypt.hashpw(rawPassword,BCrypt.gensalt());
        }
        public boolean matches(String rawPassword, String encodedPassword){
            return BCrypt.checkpw(rawPassword,encodedPassword);
        }
    }
}
