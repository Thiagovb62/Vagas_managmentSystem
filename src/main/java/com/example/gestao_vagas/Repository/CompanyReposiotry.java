package com.example.gestao_vagas.Repository;

import com.example.gestao_vagas.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyReposiotry extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);
}
