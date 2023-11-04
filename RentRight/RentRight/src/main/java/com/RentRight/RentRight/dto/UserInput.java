package com.RentRight.RentRight.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserInput(
    @NotBlank
    String name,

    @Email
    String email,

    @CPF
    String CPF,

    String password) 
{ }
