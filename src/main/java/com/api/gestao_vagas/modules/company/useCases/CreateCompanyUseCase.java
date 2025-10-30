package com.api.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.gestao_vagas.exceptions.CompanyFoundException;
import com.api.gestao_vagas.modules.company.entities.CompanyEntity;
import com.api.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity company) {
        this.companyRepository
            .findByUsernameOrEmail(company.getUsername(), company.getEmail())
            .ifPresent(exist -> {
                throw new CompanyFoundException();
            });

        company.setPassword(passwordEncoder.encode(company.getPassword()));
        return this.companyRepository.save(company);
    }
}
