package com.example.gestao_vagas.Service;

import com.example.gestao_vagas.Exceptions.CompanyExistsException;
import com.example.gestao_vagas.Models.Company;
import com.example.gestao_vagas.Models.CompanyRequestDTO;
import com.example.gestao_vagas.Models.CompanyResponseDTO;
import com.example.gestao_vagas.Repository.CompanyReposiotry;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyReposiotry companyReposiotry;


    public CompanyService(CompanyReposiotry companyReposiotry) {
        this.companyReposiotry = companyReposiotry;
    }

    public ResponseEntity<CompanyResponseDTO> getCompanyByName(String name) {
        Company company = companyReposiotry.findByName(name).orElseThrow(() -> new RuntimeException("Company not found"));
        return ResponseEntity.ok(new CompanyResponseDTO(company));
    }

    public ResponseEntity<CompanyResponseDTO> createCompany(CompanyRequestDTO dto) {
        VerifyCompanyAlreadyExists(dto.name());
        Company company = new Company(dto);
        companyReposiotry.save(company);
        return ResponseEntity.ok(new CompanyResponseDTO(company));
    }

    public void VerifyCompanyAlreadyExists(String name) {
        if (this.companyReposiotry.findByName(name).isPresent()) {
            throw new CompanyExistsException("Company already exists");
        }
    }
}
