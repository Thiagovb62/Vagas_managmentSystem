package com.example.gestao_vagas.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CompanyRequestDTO(
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username must contain only letters and numbers")
        String name,
        @Email(message = "Email should be valid")
        String email,
        @Length(min = 8, message = "Password must have at least 8 characters")
        String pswd,
        String website,
        String description
) {
}
