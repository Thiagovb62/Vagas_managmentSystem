package com.example.gestao_vagas.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "company")
public class Company {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    private String name;
    private String username;
    private String email;
    private String pswd;
    private String website;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Company() {
    }

    public Company(String name, String username,String email, String pswd, String website, String description) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.pswd = pswd;
        this.website = website;
        this.description = description;
    }

    public Company(CompanyRequestDTO company) {
        this.name = company.name();
        this.username = company.username();
        this.email = company.email();
        this.pswd = company.pswd();
        this.website = company.website();
        this.description = company.description();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
