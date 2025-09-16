package com.example.common.exceptions;

import com.example.common.dto.response.ErrorResponse;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Error;
import jakarta.inject.Singleton;

import jakarta.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@Singleton
public class GlobalExceptionHandler {

    // Handle "already exists"
    @Error(global = true)
    public HttpResponse<ErrorResponse> handleEntityExists(HttpRequest<?> request, jakarta.persistence.EntityExistsException e) {
        return HttpResponse.status(HttpStatus.CONFLICT).body(
                new ErrorResponse(
                        e.getMessage(),
                        String.valueOf(HttpStatus.CONFLICT.getCode()),
                        request.getPath(),
                        java.time.LocalDateTime.now()
                )
        );
    }

    // Handle "not found"
    @Error(global = true)
    public HttpResponse<ErrorResponse> handleEntityNotFound(HttpRequest<?> request, jakarta.persistence.EntityNotFoundException e) {
        return HttpResponse.status(HttpStatus.NOT_FOUND).body(
                new ErrorResponse(
                        e.getMessage(),
                        String.valueOf(HttpStatus.NOT_FOUND.getCode()),
                        request.getPath(),
                        java.time.LocalDateTime.now()
                )
        );
    }

    // Handle validation errors (@Valid in DTOs)
    @Error(global = true)
    public HttpResponse<ErrorResponse> handleValidationErrors(HttpRequest<?> request, ConstraintViolationException e) {
        String errors = e.getConstraintViolations()
                .stream()
                .map(v -> v.getPropertyPath() + " " + v.getMessage())
                .collect(Collectors.joining(", "));

        return HttpResponse.badRequest(
                new ErrorResponse(
                        errors,
                        String.valueOf(HttpStatus.BAD_REQUEST.getCode()),
                        request.getPath(),
                        java.time.LocalDateTime.now()
                )
        );
    }

    // Generic fallback
    @Error(global = true)
    public HttpResponse<ErrorResponse> handleGeneric(HttpRequest<?> request, RuntimeException e) {
        return HttpResponse.serverError(
                new ErrorResponse(
                        e.getMessage(),
                        String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.getCode()),
                        request.getPath(),
                        java.time.LocalDateTime.now()
                )
        );
    }
}
