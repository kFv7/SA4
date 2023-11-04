package com.RentRight.RentRight.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record ContractInput(        
    @NotBlank @Past
    Date startDate,

    @NotBlank @Past
    Date endDate) 
{ }