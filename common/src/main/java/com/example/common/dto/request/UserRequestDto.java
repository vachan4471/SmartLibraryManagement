package com.example.common.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class UserRequestDto {
    @NotBlank(message = "first Name is required")
    @Size(max = 100, message = "Name can't be more than 100 letters")
    private String firstName;

    @Size(max = 100, message = "Name can't be more than 100 letters")
    private String lastName;

    @NotBlank(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDateTime dob;

    @NotBlank(message = "email is required")
    @Size(max = 150, message = "email shouldn't be more than 150 letters")
    @Email(message = "Invalid email provided")
    private String email;

    @NotNull(message = "username is required")
    @Size(max = 100, message = "Username can't be more than 100 letters")
    private String username;

    @NotBlank(message = "password is required")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*?><])(?=.*[a-z].{8,20})")
    private String password;

    @NotBlank(message = "Role has to be mentioned")
    private  String role;

    private LocalDateTime createAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
