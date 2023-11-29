package com.RentRight.RentRight.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ApartmentInputDTO {
    @NotNull
    private Long id;

    @NotBlank
    private String address;

    @NotBlank @Min(value = 50) @Max(value = 1000000)
    private Double rentalPrice;

    @Min(value = 1)
    private Integer bathroomNumber;

    @Min(value = 1)
    private Integer bedroomsNumber;

    private Integer size;

}
