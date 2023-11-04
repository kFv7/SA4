package com.RentRight.RentRight.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ApartamentOutput(
    @NotNull
    Long id,

    @NotBlank 
    String name,

    @NotBlank
    String address,

    @NotBlank @Min(value = 50) @Max(value = 1000000)
    Double rentalPrice,

    @Min(value = 1)
    Integer bathroomNumber,

    @Min(value = 1)
    Integer bedroomsNumber,

    Integer size) 
{ }
