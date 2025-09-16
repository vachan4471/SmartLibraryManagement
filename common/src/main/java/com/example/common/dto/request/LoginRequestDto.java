package com.example.common.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginRequestDto {
    @NotNull(message = "username is required")
    @Size(max = 100, message = "Username can't be more than 100 letters")
    private String username;

    @NotBlank(message = "password is required")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*?><])(?=.*[a-z].{8,20})")
    private String password;

    @NotBlank(message = "Role has to be mentioned")
    private  String role;
}
