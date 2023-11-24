package com.RentRight.RentRight.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReservationInputDTO {
    @NotNull
    private Long id;

    @NotBlank 
    private String checkin;

    @NotBlank 
    private String checkout;

    @NotBlank
    private String reserveStatus;

    @Min(value = 50)
    private Double rentalPrice;

}
