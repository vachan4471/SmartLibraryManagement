package com.example.common.dto.response;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Introspected
public class UserResponseDto {
    private long userId;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDateTime dob;
}
