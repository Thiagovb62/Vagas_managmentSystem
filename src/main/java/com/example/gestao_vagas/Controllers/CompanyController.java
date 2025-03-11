package com.example.gestao_vagas.Controllers;

import com.example.gestao_vagas.Models.CompanyRequestDTO;
import com.example.gestao_vagas.Models.CompanyResponseDTO;
import com.example.gestao_vagas.Service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<CompanyResponseDTO> getCompanyById(String name) {
        return companyService.getCompanyByName(name);
    }

    @PostMapping
    public ResponseEntity<CompanyResponseDTO> createCompany(@Valid @RequestBody CompanyRequestDTO dto) {
        return companyService.createCompany(dto);
    }
}
