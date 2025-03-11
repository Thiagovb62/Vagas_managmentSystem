package com.example.gestao_vagas.Repository;

import com.example.gestao_vagas.Models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CandidateReposiotry extends JpaRepository<Candidate, UUID> {

    Optional<Candidate> findByUsernameOrEmail(String email, String username);
}
