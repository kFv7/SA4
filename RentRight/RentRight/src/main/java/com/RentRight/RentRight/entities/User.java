package com.RentRight.RentRight.entities;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class User {
    @Id @GeneratedValue( strategy = GenerationType.AUTO)
    
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @CPF
    private String CPF;

    private String password;
    
}
