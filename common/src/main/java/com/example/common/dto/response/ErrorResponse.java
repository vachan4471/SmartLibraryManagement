package com.example.common.dto.response;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Introspected
public class ErrorResponse {
    private String message;
    private String errorCode;
    private String path;
    private LocalDateTime errorAt = LocalDateTime.now();
}
