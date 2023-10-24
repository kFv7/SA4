package com.RentRight.RentRight.entities;

import jakarta.persistence.*;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Apartment {
    @Id @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private Double rentalPrice;
    private Integer bathroomNumber;
    private Integer bedroomsNumber;
    private Integer size;
}
