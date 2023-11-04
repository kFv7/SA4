package com.RentRight.RentRight.dto;

import java.sql.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReservationOutput(    
    @NotNull
    Long id,

    @NotBlank 
    Date checkin,

    @NotBlank 
    Date checkout,

    @NotBlank
    String reserveStatus,

    @Min(value = 50)
    Double rentalPrice)  
{ }