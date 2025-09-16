package com.example.auth.controller;

import com.example.auth.service.Imp.AuthServiceImp;
import com.example.common.dto.request.LoginRequestDto;
import com.example.common.dto.request.UserRequestDto;
import com.example.common.dto.response.UserResponseDto;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Controller("/auth")
@RequiredArgsConstructor
//we can use this, or we can use @Inject and write the constructor for authController by taking authService as parameter and using this.authService=authService for that constructor.
public class AuthController {

    private final AuthServiceImp authService;

    @Secured("isAnonymous()")  //<- used this to make this method explicit of jwt token
    @Post("/register")
    public HttpResponse<UserResponseDto> registerUser(@Valid @Body UserRequestDto requestDto){
        UserResponseDto responseDto = authService.register(requestDto);
        return HttpResponse.created(responseDto);
    }
    @Secured("isAnonymous()")
    @Get("/user/{username}")
    public HttpResponse<UserResponseDto> getUserDetails(@PathVariable String username){
        UserResponseDto responseDto = authService.getUser(username);
        return HttpResponse.ok(responseDto);
    }

    @Secured("isAnonymous()")
    @Post("/login")
    public HttpResponse<String> loginUser(@Valid @Body LoginRequestDto requestDto){
        Optional<String> token = authService.login(requestDto.getUsername(), requestDto.getPassword());
        if(token.isEmpty()){
            return HttpResponse.badRequest("Invalid Credentials");
        }
        return HttpResponse.ok(token.get());
    }
}
