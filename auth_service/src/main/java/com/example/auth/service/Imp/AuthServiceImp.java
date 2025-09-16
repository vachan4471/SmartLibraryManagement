package com.example.auth.service.Imp;

import com.example.auth.entity.User;
import com.example.auth.mapper.AuthMapper;
import com.example.auth.repository.UserRepository;
import com.example.auth.security.JwtGenerator;
import com.example.auth.security.PasswordEncoderFactory;
import com.example.auth.service.AuthService;
import com.example.common.dto.request.UserRequestDto;
import com.example.common.dto.response.UserResponseDto;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    private final UserRepository userRepo;
    private final AuthMapper authMapper;
    private final PasswordEncoderFactory.PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtGenerator;

    @Override
    public UserResponseDto register(UserRequestDto requestDto) {
        if(userRepo.existsByUsername(requestDto.getUsername())){
            throw new EntityExistsException("Username:"+requestDto.getUsername()+" Already exists");
        }
        User toSaveUser = authMapper.toEntity(requestDto);
        toSaveUser.setPassword(passwordEncoder.encode(toSaveUser.getPassword()));
        return authMapper.toResponse(userRepo.save(toSaveUser));
    }

    @Override
    public UserResponseDto getUser(String username) {
        User savedUser = userRepo.findByUsername(username).orElseThrow(
                ()->new EntityNotFoundException("Username:"+username+" Not Found")
        );
        return authMapper.toResponse(savedUser);
    }

    @Override
    public Optional<String> login(String username, String password) {
        User savedUser = userRepo.findByUsername(username).orElseThrow(
                ()-> new EntityNotFoundException("Username:"+username+" Not Found.")
        );
        return userRepo.findByUsername(username)
                .filter(user -> passwordEncoder.matches(password,user.getPassword()))
                .map(user -> jwtGenerator.generateToken(user.getUsername(),user.getRole().name()));
    }
}
