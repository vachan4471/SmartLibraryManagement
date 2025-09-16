package com.example.common.dto.response;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Introspected
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(T data, String message){
        return new ApiResponse<>(true,message,data);
    }

    public static <T> ApiResponse<T> error(T data, String message){
        return new ApiResponse<>(false,message,data);
    }

}
