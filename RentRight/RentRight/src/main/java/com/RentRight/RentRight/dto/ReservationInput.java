package com.RentRight.RentRight.dto;

import java.sql.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ReservationInput(
    @NotBlank 
    Date checkin,

    @NotBlank 
    Date checkout,

    @NotBlank
    String reserveStatus,

    @Min(value = 50)
    Double rentalPrice) 
{ }