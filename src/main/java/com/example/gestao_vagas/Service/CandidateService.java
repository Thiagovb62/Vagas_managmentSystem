package com.example.gestao_vagas.Service;

import com.example.gestao_vagas.Models.Candidate;
import com.example.gestao_vagas.Models.CandidateRequestDTO;
import com.example.gestao_vagas.Models.CandidateResponseDTO;
import com.example.gestao_vagas.Repository.CandidateReposiotry;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    private final CandidateReposiotry candidateReposiotry;

    public CandidateService(CandidateReposiotry candidateReposiotry) {
        this.candidateReposiotry = candidateReposiotry;
    }

    public List<CandidateResponseDTO> getAllCandidates() {
        List<Candidate> candidates = candidateReposiotry.findAll();
        return CandidateResponseDTO.convert(candidates);
    }

    public void createCandidate(CandidateRequestDTO dto) {
        VerifyUserAlreadyExists(dto, this.candidateReposiotry);
        Candidate candidate = new Candidate(dto);
        candidateReposiotry.save(candidate);
        System.out.println("Candidate created");
    }

    public static void VerifyUserAlreadyExists(@RequestBody @Valid CandidateRequestDTO dto, CandidateReposiotry candidateReposiotry) {
        Optional<Candidate> candidateOptional = candidateReposiotry.findByUsernameOrEmail(dto.email(), dto.username());
        if (candidateOptional.isPresent()) {
            throw new RuntimeException("Username or email already in use");
        }
    }
}
