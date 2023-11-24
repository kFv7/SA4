package com.RentRight.RentRight.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Apartment {
    public Apartment(Apartment apartment){
        this.id = getId();
        this.name = getName();
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
    private String name;

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
