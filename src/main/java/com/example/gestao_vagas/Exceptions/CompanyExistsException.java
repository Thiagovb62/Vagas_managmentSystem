package com.example.gestao_vagas.Exceptions;

public class CompanyExistsException extends RuntimeException {
    public CompanyExistsException(String message) {
        super(message);
    }
}
