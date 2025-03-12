package com.example.gestao_vagas.Controllers;

import com.example.gestao_vagas.Models.JobsRequestDTO;
import com.example.gestao_vagas.Models.JobsResponseDTO;
import com.example.gestao_vagas.Service.JobsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    private final JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobsResponseDTO>> getAllJobs(){
        return jobsService.getAllJobs();
    }

    @PostMapping
    public ResponseEntity<JobsResponseDTO> createJob(@RequestBody @Valid JobsRequestDTO dto){
        return jobsService.createJob(dto);
    }
}
