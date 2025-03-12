package com.example.gestao_vagas.Repository;

import com.example.gestao_vagas.Models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface JobsRepository extends JpaRepository<Jobs, UUID> {

    @Query("SELECT j FROM Jobs j WHERE j.company.id = :companyId")
    Optional<Jobs> findByCompanyId(UUID companyId);
}
