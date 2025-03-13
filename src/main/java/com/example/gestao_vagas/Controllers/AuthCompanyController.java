package com.example.gestao_vagas.Controllers;

import com.example.gestao_vagas.Models.AuthCompanyDTO;
import com.example.gestao_vagas.Service.AuthenticationService;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/company")
public class AuthCompanyController {

    private final AuthenticationService authenticationService;

    public AuthCompanyController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public String authCompany(@RequestBody AuthCompanyDTO dto) throws AuthenticationException {
        return authenticationService.authenticate(dto);
    }

}
