package com.example.gestao_vagas.Controllers;


import com.example.gestao_vagas.Models.CandidateRequestDTO;
import com.example.gestao_vagas.Models.CandidateResponseDTO;
import com.example.gestao_vagas.Repository.CandidateReposiotry;
import com.example.gestao_vagas.Service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/")
    public List<CandidateResponseDTO> getAllCandidates() {
       return candidateService.getAllCandidates();
    }

    @PostMapping("/")
    public void createCandidate(@Valid @RequestBody CandidateRequestDTO dto) {
        candidateService.createCandidate(dto);
    }
}
