package com.example.gestao_vagas.Service;

import com.example.gestao_vagas.Models.*;
import com.example.gestao_vagas.Repository.JobsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobsService {

    private final JobsRepository jobsRepository;
    private final CompanyService companyService;

    public JobsService(JobsRepository jobsRepository, CompanyService companyService) {
        this.jobsRepository = jobsRepository;
        this.companyService = companyService;
    }

    public ResponseEntity<List<JobsResponseDTO>> getAllJobs(){
        return ResponseEntity.ok(jobsRepository.findAll().stream().map(JobsResponseDTO::new).collect(Collectors.toList()));
    }

    public ResponseEntity<JobsResponseDTO> createJob(JobsRequestDTO jobsRequestDTO){
        Company company = companyService.getCompanyByName(jobsRequestDTO.companyName());
        VerifyJobsAlreadyOffer(company);
        var job = new Jobs(jobsRequestDTO);
        job.setCompany(company);
        return ResponseEntity.ok(new JobsResponseDTO(jobsRepository.save(job)));
    }

    private void VerifyJobsAlreadyOffer(Company company) {
        jobsRepository.findByCompanyId(company.getId()).ifPresent(jobs -> {
            throw new IllegalArgumentException("Company already has this job offer");
        });
    }
}
