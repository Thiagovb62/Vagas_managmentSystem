package com.example.gestao_vagas.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode
@Entity
@Table(name = "candidate")
public class Candidate {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    private String name;
    private String username;
    private String email;
    private String pswd;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Candidate() {
    }

    public Candidate(String name, String username, String email, String pswd, String curriculum) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.pswd = pswd;
        this.curriculum = curriculum;
    }

    public Candidate(CandidateRequestDTO candidate) {
        this.name = candidate.name();
        this.username = candidate.username();
        this.email = candidate.email();
        this.pswd = candidate.pswd();
        this.curriculum = candidate.curriculum();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", pswd='" + pswd + '\'' +
                ", curriculum='" + curriculum + '\'' +
                '}';
    }
}
