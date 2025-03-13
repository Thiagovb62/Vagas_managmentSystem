package com.example.gestao_vagas.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.gestao_vagas.Models.Company;
import com.example.gestao_vagas.Models.CompanyRequestDTO;
import com.example.gestao_vagas.Models.CompanyResponseDTO;
import com.example.gestao_vagas.Repository.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    private final PasswordEncoder encoder;


    public CompanyService(CompanyRepository companyRepository, PasswordEncoder encoder) {
        this.companyRepository = companyRepository;
        this.encoder = encoder;
    }

    public ResponseEntity<List<CompanyResponseDTO>> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return ResponseEntity.ok(CompanyResponseDTO.convert(companies));
    }

    public Company getCompanyByName(String name) {
        Optional<Company> companyOptional = this.companyRepository.findByName(name);
        if (companyOptional.isEmpty()) {
            throw new NullPointerException("Company not found");
        }
        return companyOptional.get();
    }


    public ResponseEntity<CompanyResponseDTO> getCompanyByUsernameOrEmail(String username, String email) {
        System.out.println("username: " + username);

        if (username.isEmpty() && email.isEmpty()) {
            throw new IllegalArgumentException("Username or email is required");
        }
        Optional<Company> companyOptional = this.companyRepository.findByUsernameOrEmail(username, email);
        if (companyOptional.isEmpty()) {
            throw new NullPointerException("Company not found");
        }
        return ResponseEntity.ok(new CompanyResponseDTO(companyOptional.get()));
    }

    public ResponseEntity<CompanyResponseDTO> createCompany(CompanyRequestDTO dto) {
        VerifyCompanyAlreadyExists(dto);
        Company company = new Company(dto);
        var password = encoder.encode(dto.pswd());
        company.setPswd(password);
        companyRepository.save(company);
        return ResponseEntity.ok(new CompanyResponseDTO(company));
    }

    private void VerifyCompanyAlreadyExists(CompanyRequestDTO dto) {
        Optional<Company> companyOptional = this.companyRepository.findByUsernameOrEmail(dto.username(), dto.email());
        if (companyOptional.isPresent()) {
            throw new RuntimeException("Username or email already in use");
        }
    }

}
