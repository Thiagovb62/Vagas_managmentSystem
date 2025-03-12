package com.example.gestao_vagas.Models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record JobsRequestDTO(
        @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Title must contain only letters and numbers")
        String title,
        @NotBlank(message = "Description is mandatory field")
        String description,
        String benefits,
        @NotBlank(message = "Level is mandatory field")
        String level,
        @NotEmpty(message = "Company is mandatory field")
        String companyName
) {
}
