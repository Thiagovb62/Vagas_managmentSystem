package com.example.gestao_vagas.Models;

import java.util.List;
import java.util.UUID;

public record CandidateResponseDTO(
        UUID id,
        String name,
        String username,
        String email,
        String curriculum
) {
    public CandidateResponseDTO(Candidate candidate) {
        this(candidate.getId(),candidate.getName(), candidate.getUsername(), candidate.getEmail(), candidate.getCurriculum());
    }

    public static List<CandidateResponseDTO> convert(List<Candidate> candidates) {
        return candidates.stream().map(CandidateResponseDTO::new).toList();
    }
}
