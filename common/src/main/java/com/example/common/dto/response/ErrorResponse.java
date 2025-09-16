package com.example.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class ErrorResponse {
    private String message;
    private String errorCode;
    private LocalDateTime errorAt = LocalDateTime.now();
}
