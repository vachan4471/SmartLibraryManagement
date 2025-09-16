package com.example.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserResponseDto {
    private long userId;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDateTime dob;
}
