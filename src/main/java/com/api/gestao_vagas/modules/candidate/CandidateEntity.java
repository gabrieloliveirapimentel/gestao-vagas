package com.api.gestao_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
    
    private UUID id;
    private String name;

    @NotBlank(message = "O campo [username] não deve estar em branco")
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
    private String username;

    @Email(message = "O campo [email] deve conter um email valido")
    private String email;

    @Length(min = 8, max = 32, message = "O campo [password] deve conter entre 8 e 32 caracteres")
    private String password;
    private String description;
    private String curriculum;
}
