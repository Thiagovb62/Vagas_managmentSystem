package com.example.gestao_vagas.Models;

import java.util.UUID;

public record JobsResponseDTO(
        UUID id,
        String title,
        String description,
        String benefits,
        String level,
        CompanyResponseDTO company
) {
    public JobsResponseDTO(Jobs jobs) {
        this(jobs.getId(), jobs.getTitle(), jobs.getDescription(), jobs.getBenefits(), jobs.getLevel(), new CompanyResponseDTO(jobs.getCompany()));
    }
}
