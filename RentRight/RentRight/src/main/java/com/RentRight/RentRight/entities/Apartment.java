package com.RentRight.RentRight.entities;

import com.RentRight.RentRight.dto.ApartmentInputDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Apartment {
    public Apartment(ApartmentInputDTO apartmentInput){
        this.id = getId();
        this.address = getAddress();
        this.rentalPrice = getRentalPrice();
        this.bathroomNumber = getBathroomNumber();
        this.bedroomsNumber = getBedroomsNumber();
        this.size = getSize();
    }

    @Id @GeneratedValue( strategy = GenerationType.AUTO)
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
