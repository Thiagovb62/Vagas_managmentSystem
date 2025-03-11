package com.example.gestao_vagas.Models;

public record JobsRequestDTO(
        String title,
        String description,
        String benefits,
        String level,
        Company company
) {
}
