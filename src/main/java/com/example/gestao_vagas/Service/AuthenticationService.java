package com.example.gestao_vagas.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.gestao_vagas.Models.AuthCompanyDTO;
import com.example.gestao_vagas.Repository.CompanyRepository;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Value("${security.token.secret}")
    String secretKey;

    private final CompanyRepository companyRepository;

    private final PasswordEncoder encoder;

    public AuthenticationService( CompanyRepository companyRepository, PasswordEncoder encoder) {
        this.companyRepository = companyRepository;
        this.encoder = encoder;
    }

    public String authenticate(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        if (authCompanyDTO.username().isEmpty() || authCompanyDTO.pswd().isEmpty()) {
            throw new IllegalArgumentException("Username and password are required");
        }

        var company = companyRepository.findByUsername(authCompanyDTO.username());

       var passwordMatches = encoder.matches(authCompanyDTO.pswd(), company.getPswd());

        if (!passwordMatches) {
            throw new AuthenticationException("Invalid username or password");
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withSubject(company.getUsername())
                .withSubject(company.getName())
                .sign(algorithm);


    }

}
