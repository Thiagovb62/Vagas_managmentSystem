package com.example.gestao_vagas.Controllers;

import com.example.gestao_vagas.Models.Candidate;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public void createCandidate(@Valid @RequestBody Candidate candidate) {
        System.out.println(candidate.toString());
    }
}
