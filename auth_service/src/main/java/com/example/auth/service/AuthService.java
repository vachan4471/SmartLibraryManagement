package com.example.auth.service;

import com.example.common.dto.request.UserRequestDto;
import com.example.common.dto.response.UserResponseDto;

import java.util.Optional;

public interface AuthService {
    UserResponseDto register(UserRequestDto requestDto);
    UserResponseDto getUser(String username);
    Optional<String> login(String username, String password);
}
