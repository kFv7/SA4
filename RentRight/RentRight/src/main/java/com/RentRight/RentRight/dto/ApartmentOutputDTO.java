package com.RentRight.RentRight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ApartmentOutputDTO {
    
    private Long id;
    private String address;
    private Double rentalPrice;
    private Integer bathroomNumber;
    private Integer bedroomsNumber;
    private Integer size;
}
