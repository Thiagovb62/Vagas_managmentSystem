package com.example.gestao_vagas.Models;

import java.util.List;
import java.util.UUID;

public record CompanyResponseDTO(
        UUID id,
        String name,
        String username,
        String email,
        String website,
        String description
) {
    public CompanyResponseDTO(Company company) {
        this(company.getId(), company.getName(),company.getUsername(), company.getEmail(), company.getWebsite(), company.getDescription());
    }

    public static List<CompanyResponseDTO> convert(List<Company> company) {
        return company.stream().map(CompanyResponseDTO::new).toList();
    }
}
