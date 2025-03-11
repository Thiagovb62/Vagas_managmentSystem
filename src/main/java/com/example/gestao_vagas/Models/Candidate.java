package com.example.gestao_vagas.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@EqualsAndHashCode
@Entity
@Table(name = "candidate")
public class Candidate {

    @GeneratedValue(generator = "UUID",strategy = jakarta.persistence.GenerationType.AUTO)
    @Id
    private UUID id;

    private String name;
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username must contain only letters and numbers")
    private String username;

    @Email(message = "Email should be valid")
    private String email;
    @Length(min = 8, message = "Password must have at least 8 characters")
    private String pswd;
    private String curriculum;

    public Candidate() {
    }

    public Candidate(String name, String username, String email, String pswd, String curriculum) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.pswd = pswd;
        this.curriculum = curriculum;
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
